package test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.viatra.cep.core.api.engine.CEPEngine;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.streams.EventStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.incquerylabs.viatra.cep.example.query_events.vepl.CepFactory;
import com.incquerylabs.viatra.cep.example.query_events.vepl.mapping.QueryEngine2ViatraCep;

public class CEPQueryEventTest {
	
	public static int firingsOfEvent1 = 0;
	public static int firingsOfEvent2 = 0;
	
	
	private ResourceSet scopeRoot;
	private Resource modelRoot;
	
	private CEPEngine firstEngine;
	
	private EventStream firstEventStream;
	
	@Before
	public void setUp() {
		firstEngine = CEPEngine.newEngine().eventContext(EventContext.CHRONICLE).rules(CepFactory.getInstance().allRules()).prepare();
		firstEventStream = firstEngine.getStreamManager().newEventStream();
		
		scopeRoot = new ResourceSetImpl();
		modelRoot = scopeRoot.createResource(URI.createFileURI("fake_name.xmi"));
		
		QueryEngine2ViatraCep.register(scopeRoot, firstEventStream);
	}
	
	@Test
	public void test() {
		EClass class1 = EcoreFactory.eINSTANCE.createEClass();
		class1.setName("C1");
		modelRoot.getContents().add(class1);
		EClass class2 = EcoreFactory.eINSTANCE.createEClass();
		class2.setName("C2");
		modelRoot.getContents().add(class2);
		EClass class3 = EcoreFactory.eINSTANCE.createEClass();
		class3.setName("C3");
		modelRoot.getContents().add(class3);
		
		EReference reference1 = EcoreFactory.eINSTANCE.createEReference();
		reference1.setEType(class3);
		class1.getEStructuralFeatures().add(reference1);
		EReference reference2 = EcoreFactory.eINSTANCE.createEReference();
		reference2.setEType(class3);
		class2.getEStructuralFeatures().add(reference2);
		
		Assert.assertEquals(0, firingsOfEvent1);
		Assert.assertEquals(0, firingsOfEvent2);
		
		System.out.println("Setting containment...");
		
		reference1.setContainment(true);
		reference2.setContainment(true);
		
		Assert.assertEquals(2, firingsOfEvent1);
		Assert.assertEquals(1, firingsOfEvent2);
	}
	
}
