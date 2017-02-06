package test;

import org.eclipse.viatra.cep.core.api.engine.CEPEngine;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.streams.EventStream;
import org.junit.Before;
import org.junit.Test;

import vepl.CepFactory;
import vepl.events.FIRST_Event;
import vepl.events.SECOND_Event;
import vepl.events.THIRD_Event;

public class CepParameterCheckTest {
	
	private CEPEngine firstEngine;
	
	private EventStream firstEventStream;
	
	@Before
	public void setUp() {
		firstEngine = CEPEngine.newEngine().eventContext(EventContext.CHRONICLE).rules(CepFactory.getInstance().allRules()).prepare();
		firstEventStream = firstEngine.getStreamManager().newEventStream();
	}
	
	@Test
	public void test() {
		FIRST_Event first = CepFactory.getInstance().createFIRST_Event();
		SECOND_Event second = CepFactory.getInstance().createSECOND_Event();
		THIRD_Event third_A = CepFactory.getInstance().createTHIRD_Event();
		THIRD_Event third_B = CepFactory.getInstance().createTHIRD_Event();
		
		first.setRight(true);
		second.setRight(true);
		third_A.setFoo(100);
		third_A.setRight(true);
		third_B.setFoo(200);
		third_B.setRight(false);
		
		firstEventStream.push(first);
		firstEventStream.push(second);
		firstEventStream.push(third_B);
		firstEventStream.push(third_A);
	}
	
}
