package org.eclipse.viatra.cep.emf.notification.integration;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.viatra.cep.core.api.engine.CEPEngine;
import org.eclipse.viatra.cep.core.streams.EventStream;
import org.eclipse.viatra.cep.emf.notification.model.CepFactory;
import org.eclipse.viatra.cep.emf.notification.model.events.ADD_Event;
import org.eclipse.viatra.cep.emf.notification.model.events.ADD_MANY_Event;
import org.eclipse.viatra.cep.emf.notification.model.events.MOVE_Event;
import org.eclipse.viatra.cep.emf.notification.model.events.REMOVE_Event;
import org.eclipse.viatra.cep.emf.notification.model.events.REMOVE_MANY_Event;
import org.eclipse.viatra.cep.emf.notification.model.events.RESOLVE_Event;
import org.eclipse.viatra.cep.emf.notification.model.events.SET_Event;
import org.eclipse.viatra.cep.emf.notification.model.events.UNSET_Event;

public class NotificationAdapter {
	private static final String LOGGER_NAME = "org.eclipse.viatra.cep.emf.notification.integration";
	private static final String EVENT_OBSERVED_MSG = "%s event observed.";
	private Logger logger = Logger.getLogger(LOGGER_NAME);

	private Adapter adapter;
	private Notifier notifier;
	private EventStream eventStream;

	public NotificationAdapter(Notifier notifier, EventStream eventStream) {
		this.notifier = notifier;
		this.eventStream = eventStream;
		setAdapter();
		setDebugLevel(Level.OFF);
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
					logger.debug(String.format(EVENT_OBSERVED_MSG, "Notification.ADD"));
					ADD_Event addEvent = CepFactory.getInstance().createADD_Event();
					addEvent.setNotifier(notification.getNotifier());
					addEvent.setFeature(notification.getFeature());
					addEvent.setOldValue(notification.getOldValue());
					addEvent.setNewValue(notification.getNewValue());
					eventStream.push(addEvent);
					break;
				case Notification.ADD_MANY:
					logger.debug(String.format(EVENT_OBSERVED_MSG, "Notification.ADD_MANY"));
					ADD_MANY_Event addManyEvent = CepFactory.getInstance().createADD_MANY_Event();
					addManyEvent.setNotifier(notification.getNotifier());
					addManyEvent.setFeature(notification.getFeature());
					addManyEvent.setOldValue(notification.getOldValue());
					addManyEvent.setNewValue(notification.getNewValue());
					eventStream.push(addManyEvent);
					break;
				case Notification.MOVE:
					logger.debug(String.format(EVENT_OBSERVED_MSG, "Notification.MOVE"));
					MOVE_Event moveEvent = CepFactory.getInstance().createMOVE_Event();
					moveEvent.setNotifier(notification.getNotifier());
					moveEvent.setFeature(notification.getFeature());
					moveEvent.setOldValue(notification.getOldValue());
					moveEvent.setNewValue(notification.getNewValue());
					eventStream.push(moveEvent);
					break;
				case Notification.REMOVE:
					logger.debug(String.format(EVENT_OBSERVED_MSG, "Notification.REMOVE"));
					REMOVE_Event removeEvent = CepFactory.getInstance().createREMOVE_Event();
					removeEvent.setNotifier(notification.getNotifier());
					removeEvent.setFeature(notification.getFeature());
					removeEvent.setOldValue(notification.getOldValue());
					removeEvent.setNewValue(notification.getNewValue());
					eventStream.push(removeEvent);
					break;
				case Notification.REMOVE_MANY:
					logger.debug(String.format(EVENT_OBSERVED_MSG, "Notification.REMOVE_MANY"));
					REMOVE_MANY_Event removeManyEvent = CepFactory.getInstance().createREMOVE_MANY_Event();
					removeManyEvent.setNotifier(notification.getNotifier());
					removeManyEvent.setFeature(notification.getFeature());
					removeManyEvent.setOldValue(notification.getOldValue());
					removeManyEvent.setNewValue(notification.getNewValue());
					eventStream.push(removeManyEvent);
					break;
				case Notification.RESOLVE:
					logger.debug(String.format(EVENT_OBSERVED_MSG, "Notification.RESOLVE"));
					RESOLVE_Event resolveEvent = CepFactory.getInstance().createRESOLVE_Event();
					resolveEvent.setNotifier(notification.getNotifier());
					resolveEvent.setFeature(notification.getFeature());
					resolveEvent.setOldValue(notification.getOldValue());
					resolveEvent.setNewValue(notification.getNewValue());
					eventStream.push(resolveEvent);
					break;
				case Notification.SET:
					logger.debug(String.format(EVENT_OBSERVED_MSG, "Notification.SET"));
					SET_Event setEvent = CepFactory.getInstance().createSET_Event();
					setEvent.setNotifier(notification.getNotifier());
					setEvent.setFeature(notification.getFeature());
					setEvent.setOldValue(notification.getOldValue());
					setEvent.setNewValue(notification.getNewValue());
					eventStream.push(setEvent);
					break;
				case Notification.UNSET:
					logger.debug(String.format(EVENT_OBSERVED_MSG, "Notification.UNSET"));
					UNSET_Event unsetEvent = CepFactory.getInstance().createUNSET_Event();
					unsetEvent.setNotifier(notification.getNotifier());
					unsetEvent.setFeature(notification.getFeature());
					unsetEvent.setOldValue(notification.getOldValue());
					unsetEvent.setNewValue(notification.getNewValue());
					eventStream.push(unsetEvent);
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

	public void setDebugLevel(Level level) {
		logger.setLevel(level);
	}

	public void dispose() {
		notifier.eAdapters().remove(adapter);
		logger = null;
		adapter = null;
	}
}
