package test;

import org.eclipse.viatra.cep.core.api.engine.CEPEngine;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.streams.EventStream;
import org.junit.Before;
import org.junit.Test;

import vepl.CepFactory;
import vepl.events.FIRST_Event;
import vepl.events.SECOND_Event;

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
		
		first.setRight(true);
		second.setRight(true);
		
		firstEventStream.push(first);
		firstEventStream.push(second);
	}
	
}
