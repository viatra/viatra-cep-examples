package com.incquerylabs.iot.pincodedemo.commons.ui;

import com.incquerylabs.iot.pincodedemo.commons.mqtt.Publisher;

public class VisualizerCommandSender {

	private static VisualizerCommandSender instance = null;

	private String LOCKING_STATE_TOPIC = "lock/all/state";

	public static String brokerUrl = "tcp://127.0.0.1:1883";

	public static VisualizerCommandSender getInstance() {
		if (instance == null) {
			return new VisualizerCommandSender(brokerUrl);
		}
		return instance;
	}

	private Publisher publisher;

	private VisualizerCommandSender(String brokerUrl) {
		this.publisher = new Publisher(brokerUrl, "visualizer_" + System.nanoTime());
		this.publisher.connect();
	}

	public void sendLockPositionChangeMessage(String lockID, int position) {
		if (this.publisher != null && this.publisher.isConnected()) {
			String topic = calculateTopic(lockID);
			String msg = createPosChangeMsg(position);

			this.publisher.publish(topic, msg);
		} else {
			System.err.println("Publisher is not connected (VisualizerCommandSender.sendLockPositionChangeMessage)");
		}
	}

	public void sendLockingStateChangeMessgae(LockingState state) {
		if (this.publisher != null && this.publisher.isConnected()) {
			String msg = createLockingStateMsg(state);
			this.publisher.publish(LOCKING_STATE_TOPIC, msg);
		} else {
			System.err.println("Publisher is not connected (VisualizerCommandSender.sendLockingStateChangeMessgae)");
		}
	}

	public String createLockingStateMsg(LockingState newState) {
		return "{ \"state\" : \"" + newState.name().toLowerCase() + "\"}";
	}

	public String createPosChangeMsg(int newPosition) {
		return "{ \"position\" :" + newPosition + "}";
	}

	public String calculateTopic(String lockID) {
		int sensorID = 0;
		switch (lockID) {
			case "A": {
				sensorID = 1;
				break;
			}
			case "B": {
				sensorID = 2;
				break;
			}
			case "C": {
				sensorID = 3;
				break;
			}
			case "D": {
				sensorID = 4;
				break;
			}
			default: {
				sensorID = 0; // XXX
			}
		}

		return "lock/" + sensorID + "/pos_change";
	}

}
