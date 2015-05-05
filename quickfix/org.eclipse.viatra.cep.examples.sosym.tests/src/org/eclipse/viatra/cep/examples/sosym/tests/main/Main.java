package org.eclipse.viatra.cep.examples.sosym.tests.main;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.incquery.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem;
import org.eclipse.incquery.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemFactory;
import org.eclipse.incquery.examples.cps.cyberPhysicalSystem.HostInstance;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.validation.core.ValidationEngine;
import org.eclipse.incquery.validation.core.api.IConstraint;
import org.eclipse.incquery.validation.core.api.IConstraintSpecification;
import org.eclipse.incquery.validation.core.api.IEntry;
import org.eclipse.incquery.validation.core.api.IViolation;
import org.eclipse.incquery.validation.core.listeners.ConstraintListener;
import org.eclipse.incquery.validation.core.listeners.ViolationListener;
import org.eclipse.viatra.cep.core.api.engine.CEPEngine;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.streams.EventStream;
import org.eclipse.viatra.cep.examples.sosym.dse.QuickFixGeneration;
import org.eclipse.viatra.cep.examples.sosym.eventmodel.CepFactory;
import org.eclipse.viatra.cep.examples.sosym.eventmodel.events.InvalidModel_Event;
import org.eclipse.viatra.cep.examples.sosym.eventmodel.events.ValidModel_Event;
import org.eclipse.viatra.cep.examples.sosym.interfaces.LoggerWrapper;
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalCpuConstraint0;
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalHddConstraint0;
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalRamConstraint0;
import org.eclipse.viatra.cep.examples.sosym.tests.internal.LoggerUtils;
import org.eclipse.viatra.cep.examples.sosym.tests.modelmanipulations.ModelInitialization;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class Main extends HeadlessTest {
    private final Logger logger = LoggerUtils.getInstance().getLogger();

    private CyberPhysicalSystem sourceModel = CyberPhysicalSystemFactory.eINSTANCE.createCyberPhysicalSystem();
    private CEPEngine cepEngine;
    private EventStream eventStream;
    private ValidationEngine validationEngine;

    @Before
    public void setUp() throws Exception {
        setUpLoggers();
        setUpCPS();
        setUpCepEngine();
        setUpValidationEngine();
        QuickFixGeneration.initialize(sourceModel, logger);
    }

    @After
    public void tearDown() throws Exception {
        sourceModel = null;
        cepEngine = null;

        validationEngine.dispose();
        LoggerWrapper.dispose();
        QuickFixGeneration.dispose();
    }

    @Test
    public void test() throws IncQueryException {
        logger.debug("TEST:\tSTARTING");
        HostInstance hostInstance = sourceModel.getHostTypes().get(0).getInstances().get(0);

        for (int i = 11; i > 5; i--) {
            logger.debug(String.format("Changing available CPU from %d to %d", hostInstance.getAvailableCpu(), i));
            hostInstance.setAvailableCpu(i);
        }

        logger.debug("Changing available CPU from 10 to 2");
        hostInstance.setAvailableCpu(2);

        logger.debug("TEST:\tENDING");
    }

    private void setUpCPS() {
        ModelInitialization.initializeSource(sourceModel);
    }

    private void setUpCepEngine() {
        cepEngine = CEPEngine.newEngine(EventContext.STRICT_IMMEDIATE);
        eventStream = cepEngine.getStreamManager().newEventStream();
        cepEngine.addRules(CepFactory.getInstance().allRules());
    }

    private void setUpLoggers() {
        logger.setLevel(Level.DEBUG);
        LoggerWrapper.initialize(logger);
    }

    private void setUpValidationEngine() throws IncQueryException {
        List<IConstraintSpecification> constraintSpecs = Lists.newArrayList(
                new AvailableGreaterThanTotalCpuConstraint0(), new AvailableGreaterThanTotalHddConstraint0(),
                new AvailableGreaterThanTotalRamConstraint0());

        validationEngine = new ValidationEngine(sourceModel, logger);
        for (IConstraintSpecification constraintSpecification : constraintSpecs) {
            IConstraint constraint = validationEngine.addConstraintSpecification(constraintSpecification);

            constraint.addListener(new ConstraintListener() {
                @Override
                public void violationAppeared(IViolation violation) {
                    violation.addListener(new ViolationListener() {
                        public void violationEntryAppeared(IViolation violation, IEntry entry) {
                            InvalidModel_Event event = CepFactory.getInstance().createInvalidModel_Event();
                            event.setSourceElement(violation.getKeyObjects().values().toArray()[0]);
                            eventStream.push(event);
                        }

                        public void violationMessageUpdated(IViolation violation) {
                            InvalidModel_Event event = CepFactory.getInstance().createInvalidModel_Event();
                            event.setSourceElement(violation.getKeyObjects().values().toArray()[0]);
                            eventStream.push(event);
                        }

                        public void violationEntryDisappeared(IViolation violation, IEntry entry) {
                            ValidModel_Event event = CepFactory.getInstance().createValidModel_Event();
                            event.setSourceElement(violation.getKeyObjects().values().toArray()[0]);
                            eventStream.push(event);
                        }
                    });
                }

                @Override
                public void violationDisappeared(IViolation violation) {
                }
            });
        }

        validationEngine.initialize();
    }
}
