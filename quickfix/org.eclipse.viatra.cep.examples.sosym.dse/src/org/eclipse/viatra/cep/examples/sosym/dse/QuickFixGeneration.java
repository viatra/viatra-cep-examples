package org.eclipse.viatra.cep.examples.sosym.dse;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.eclipse.incquery.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem;
import org.eclipse.incquery.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage;
import org.eclipse.incquery.examples.cps.cyberPhysicalSystem.HostInstance;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalCpu2Match;
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalCpu2Matcher;
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalCpuMatch;
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalCpuMatcher;
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalHddMatch;
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalHddMatcher;
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalRamMatch;
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalRamMatcher;
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalCpu2Processor;
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalCpu2QuerySpecification;
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalCpuProcessor;
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalCpuQuerySpecification;
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalHddProcessor;
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalHddQuerySpecification;
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalRamProcessor;
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalRamQuerySpecification;
import org.eclipse.viatra.dse.api.DSETransformationRule;
import org.eclipse.viatra.dse.api.DesignSpaceExplorer;
import org.eclipse.viatra.dse.api.Solution;
import org.eclipse.viatra.dse.api.Strategies;
import org.eclipse.viatra.dse.objectives.impl.ModelQueriesHardObjective;
import org.eclipse.viatra.dse.objectives.impl.ModelQueryType;
import org.eclipse.viatra.dse.statecode.incrementalgraph.IncrementalGraphHasherFactory;

import com.google.common.base.Preconditions;

public class QuickFixGeneration {
    private static QuickFixGeneration instance;

    private CyberPhysicalSystem cps;
    private Logger logger;

    public static QuickFixGeneration initialize(CyberPhysicalSystem cps, Logger logger) {
        if (instance == null) {
            instance = new QuickFixGeneration(cps, logger);
        }
        return instance;
    }

    public static QuickFixGeneration getInstance() {
        Preconditions.checkArgument(instance != null);
        return instance;
    }

    private QuickFixGeneration(CyberPhysicalSystem cps, Logger logger) {
        this.cps = cps;
        this.logger = logger;
    }

    public Collection<Solution> generateQuickFixes() throws IncQueryException {
        logger.debug("Setting up DSE");

        DesignSpaceExplorer dse = new DesignSpaceExplorer();

        dse.setInitialModel(cps);

        logger.debug("Adding transformtion rules");
        TransformationRules.setTransformationRules(dse);

        logger.debug("Adding objectives");
        dse.addObjective(new ModelQueriesHardObjective("validation objective")
                .withConstraint(AvailableGreaterThanTotalCpuQuerySpecification.instance())
                .withType(ModelQueryType.NO_MATCH)
                .withConstraint(AvailableGreaterThanTotalHddQuerySpecification.instance())
                .withType(ModelQueryType.NO_MATCH)
                .withConstraint(AvailableGreaterThanTotalRamQuerySpecification.instance())
                .withType(ModelQueryType.NO_MATCH));

        logger.debug("State encoding");
        dse.addMetaModelPackage(CyberPhysicalSystemPackage.eINSTANCE);
        dse.setSerializerFactory(new IncrementalGraphHasherFactory(dse.getMetaModelPackages()));

        logger.debug("Starting exploration");
        dse.startExploration(Strategies.createDFSStrategy(5));

        return dse.getSolutions();
    }

    public static void dispose() {
        instance = null;
    }


}
