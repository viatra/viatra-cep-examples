package org.eclipse.viatra.cep.emf.notification.integration;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.viatra.cep.core.api.engine.CEPEngine;
import org.eclipse.viatra.cep.core.streams.EventStream;
import org.eclipse.viatra.cep.emf.notification.model.CepFactory;
import org.eclipse.viatra.cep.emf.notification.model.events.SET_Event;

public class NotificationAdapter {
	private Logger logger;	//TODO
	private Adapter adapter;

	private Notifier notifier;
	private EventStream eventStream;

	public NotificationAdapter(Notifier notifier, EventStream eventStream) {
		this.notifier = notifier;
		this.eventStream = eventStream;
		setAdapter();
	}

	public NotificationAdapter(Notifier notifier, CEPEngine cepEngine) {
		this(notifier, cepEngine.getStreamManager().newEventStream());
	}

	private void setAdapter() {
		adapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification notification) {
				switch (notification.getEventType()) {
				case Notification.ADD:
					eventStream.push(CepFactory.getInstance().createADD_Event());
					break;
				case Notification.ADD_MANY:
					eventStream.push(CepFactory.getInstance().createADD_MANY_Event());
					break;
				case Notification.MOVE:
					eventStream.push(CepFactory.getInstance().createMOVE_Event());
					break;
				case Notification.REMOVE:
					eventStream.push(CepFactory.getInstance().createREMOVE_Event());
					break;
				case Notification.REMOVE_MANY:
					eventStream.push(CepFactory.getInstance().createREMOVE_MANY_Event());
					break;
				case Notification.RESOLVE:
					eventStream.push(CepFactory.getInstance().createRESOLVE_Event());
					break;
				case Notification.SET:
					SET_Event set_Event = CepFactory.getInstance().createSET_Event();
					set_Event.setFeature(notification.getFeature());
					eventStream.push(set_Event);
					break;
				case Notification.UNSET:
					eventStream.push(CepFactory.getInstance().createUNSET_Event());
					break;
				default:
					break;
				}
			}
		};
		notifier.eAdapters().add(this.adapter);
	}

	public Adapter getAdapter() {
		return adapter;
	}

	public void dispose() {
		notifier.eAdapters().remove(adapter);
		adapter = null;
	}
}
