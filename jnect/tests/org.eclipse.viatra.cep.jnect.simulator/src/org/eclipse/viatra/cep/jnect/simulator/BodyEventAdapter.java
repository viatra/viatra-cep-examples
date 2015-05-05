package org.eclipse.viatra.cep.jnect.simulator;

import java.awt.EventQueue;

import org.eclipse.viatra.cep.core.metamodels.events.Event;

public class BodyEventAdapter implements ICepAdapter {
    private EventQueue eventQueue;

    public BodyEventAdapter() {
        this.eventQueue = EventQueue.getInstance();
    }

    @Override
    public void push(Event event) {
        eventQueue.push(event);
    }

}
