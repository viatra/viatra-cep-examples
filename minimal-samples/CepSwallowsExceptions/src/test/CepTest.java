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
	public void test() {
		firstEventStream.push(CepFactory.getInstance().createNPE_Event());
		firstEventStream.push(CepFactory.getInstance().createCCE_Event());
	}
	
}
