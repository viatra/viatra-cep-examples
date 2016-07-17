package com.incquerylabs.iot.pincodedemo.viatracep.stream;

import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.viatra.cep.core.api.engine.CEPEngine;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.metamodels.events.Event;
import org.eclipse.viatra.cep.core.streams.EventStream;

import com.incquerylabs.iot.pincodedemo.commons.model.CodeEvent;
import com.incquerylabs.iot.pincodedemo.commons.stream.IEventStreamProvider;
import com.incquerylabs.iot.pincodedemo.viatracep.events.CepFactory;

public class ViatraCepEventStreamProvider implements IEventStreamProvider {
	
	protected CEPEngine engine;
	
	protected static AtomicReference<EventStream> eventStream;
	
	public ViatraCepEventStreamProvider() {
		engine = CEPEngine.newEngine().eventContext(EventContext.STRICT_IMMEDIATE)
				.rules(CepFactory.getInstance().allRules()).prepare();
		eventStream = new AtomicReference<EventStream>(engine.getStreamManager().newEventStream());
	}
	
	@Override
	public void push(CodeEvent event) {
		
		String methodName = "createSensor_" + event.getSource().name() + "_state_" + event.getValue() + "_Event";
		
		try {
			Event cepEvent = (Event) CepFactory.getInstance().getClass().getMethod(methodName).invoke(CepFactory.getInstance());
			pushEvent(cepEvent);
		} catch (Exception e) {
			System.err.println("Unable to push event: " + event);
			e.printStackTrace();
		}

		
	}
	
	public static void pushEvent(Event event) {
		eventStream.get().push(event);
	}
	
	public static void pushInitEvent() {
		eventStream.get().push(CepFactory.getInstance().createINIT_ATOM_Event());
	}
	
	@Override
	public void dispose() {
		eventStream = null;
		engine = null;
	}

}
