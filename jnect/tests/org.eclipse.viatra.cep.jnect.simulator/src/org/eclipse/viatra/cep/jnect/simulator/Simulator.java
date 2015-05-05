package org.eclipse.viatra.cep.jnect.simulator;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.viatra.cep.core.api.engine.CEPEngine;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.streams.EventStream;
import org.eclipse.viatra.cep.jnect.bodies.bodiesmodel.BodiesmodelFactory;
import org.eclipse.viatra.cep.jnect.bodies.bodiesmodel.Model;
import org.eclipse.viatra.cep.jnect.eventmodel.CepFactory;
import org.eclipse.viatra.cep.jnect.eventmodel.mapping.QueryEngine2ViatraCep;
import org.jnect.bodymodel.Body;
import org.jnect.core.impl.capture.persistence.Capture;
import org.jnect.core.impl.capture.persistence.Change;

import com.google.common.base.Function;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

public class Simulator {
	private static Simulator instance;

	private Simulator() {
	}

	public static Simulator getInstance() {
		if (instance == null) {
			instance = new Simulator();
		}
		return instance;
	}

	private Model model;
	private Resource resource;
	private ResourceSet resourceSet;
	private Capture capture;
	private int bodyNumber;
	private long speed;
	private CEPEngine cepEngine = CEPEngine.newEngine(EventContext.CHRONICLE);
	private EventStream eventStream = cepEngine.getStreamManager().newEventStream();
	private QueryEngine2ViatraCep mapping;

	public void setup(Capture capture, int bodyNumber, long speed) {
		this.capture = capture;
		this.bodyNumber = bodyNumber;
		this.speed = speed;
		initializeEngine();
		prepareModel();
	}

	private void initializeEngine() {
		cepEngine.addRule(CepFactory.getInstance().createFSFE_Rule());
		mapping = QueryEngine2ViatraCep.register(resourceSet, eventStream);
	}

	private void prepareModel() {
		model = BodiesmodelFactory.eINSTANCE.createModel();
		addBodies();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("bodies", new XMIResourceFactoryImpl());
		resourceSet = new ResourceSetImpl();
		resource = resourceSet.createResource(URI.createURI("bodies/model.tr"));
		resource.getContents().add(model);
	}

	private void addBodies() {
		for (int i = 0; i < bodyNumber; i++) {
			Body body = ModelUtils.newBody();
			ModelUtils.setBasePosture(body, capture.getBasePosture());
			model.getBodies().add(body);
		}
	}

	public void simulate() throws InterruptedException {
		List<Body> bodies = model.getBodies();
		System.out.println(bodies.size() + " bodies in the model");

		List<Change> changes = capture.getChanges();
		final Multimap<Long, Change> groupedChanges = groupByTimestamp(changes);

		while (true) {
			for (int i = 0; i < bodyNumber; i++) {
				Iterator<Long> keyIterator = groupedChanges.asMap().keySet().iterator();
				while (keyIterator.hasNext()) {
					Long currentTimestamp = keyIterator.next();
					if (speed > 0l) {
						Thread.sleep(speed);
					}

					Collection<Change> atomicChanges = groupedChanges.get(currentTimestamp);
					for (Change change : atomicChanges) {
						for (Body body : model.getBodies()) {
							ModelUtils.manipulateModel(body, change);
						}
					}
				}
			}
		}
	}

	private Multimap<Long, Change> groupByTimestamp(List<Change> changes) {
		Multimap<Long, Change> grouped = Multimaps.index(changes, new Function<Change, Long>() {
			@Override
			public Long apply(Change change) {
				return change.getTimestamp();
			}
		});
		return grouped;
	}

	public void dispose() {
		mapping.dispose();
		cepEngine = null;
		eventStream = null;
		instance = null;
	}
}
