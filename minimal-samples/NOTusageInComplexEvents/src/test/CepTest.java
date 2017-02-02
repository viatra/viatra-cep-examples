package test;

import org.eclipse.viatra.cep.core.api.engine.CEPEngine;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.streams.EventStream;
import org.junit.Before;
import org.junit.Test;

import vepl.CepFactory;

public class CepTest {
	
	private CEPEngine firstEngine;
	
	private EventStream firstEventStream;
	
	@Before
	public void setUp() {
		firstEngine = CEPEngine.newEngine().eventContext(EventContext.CHRONICLE).rules(CepFactory.getInstance().allRules()).prepare();
		firstEventStream = firstEngine.getStreamManager().newEventStream();
	}
	
	@Test
	public void test() throws InterruptedException {
		
		firstEventStream.push(CepFactory.getInstance().createA_Event());
		
		Thread.sleep(1000);
		
		firstEventStream.push(CepFactory.getInstance().createB_Event());
	
	}
	
}
