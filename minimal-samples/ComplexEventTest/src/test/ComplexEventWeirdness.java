package test;

import org.eclipse.viatra.cep.core.api.engine.CEPEngine;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.streams.EventStream;
import org.junit.Before;
import org.junit.Test;

import vepl.CepFactory;
import vepl.events.A_Event;
import vepl.events.B_Event;
import vepl.events.C_Event;
import vepl.events.D_Event;

public class ComplexEventWeirdness {
	
	private CEPEngine engine;
	
	private EventStream eventStream;
	
	@Before
	public void setUp() {
		engine = CEPEngine.newEngine().eventContext(EventContext.CHRONICLE).rules(CepFactory.getInstance().allRules()).prepare();
		eventStream = engine.getStreamManager().newEventStream();
	}
	
	@Test
	public void test_ABC() {
		A_Event a = CepFactory.getInstance().createA_Event();
		B_Event b = CepFactory.getInstance().createB_Event();
		C_Event c = CepFactory.getInstance().createC_Event();
		D_Event d = CepFactory.getInstance().createD_Event();
		
		eventStream.push(b);
		eventStream.push(c);
		eventStream.push(a);
		
	}
	
}
