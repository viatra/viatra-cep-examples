package org.eclipse.viatra.cep.notification.test.cases;

import org.apache.log4j.Level;
import org.eclipse.viatra.cep.core.api.engine.CEPEngine;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.emf.notification.integration.NotificationAdapter;
import org.eclipse.viatra.cep.notification.test.CepFactory;
import org.eclipse.viatra.cep.notification.test.model.carmodel.Car;
import org.eclipse.viatra.cep.notification.test.model.carmodel.CarmodelFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BaseTests {
	private Car car;
	private NotificationAdapter notificationAdapter;
	private CEPEngine cepEngine;

	@Before
	public void setUp() throws Exception {
		car = CarmodelFactory.eINSTANCE.createCar();
		cepEngine = CEPEngine.newEngine().eventContext(EventContext.CHRONICLE).rules(CepFactory.getInstance().allRules()).prepare();
		notificationAdapter = new NotificationAdapter(car, cepEngine);
		notificationAdapter.setDebugLevel(Level.DEBUG);
	}

	@After
	public void tearDown() throws Exception {
		car = null;
		notificationAdapter.dispose();
		cepEngine = null;
	}

	@Test
	public void test() {
		car.setEngine(CarmodelFactory.eINSTANCE.createEngine());
		car.setEngine(null);
	}

}
