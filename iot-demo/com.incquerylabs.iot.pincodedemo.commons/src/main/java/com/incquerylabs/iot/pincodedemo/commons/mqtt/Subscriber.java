package com.incquerylabs.iot.pincodedemo.commons.mqtt;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Subscriber {

	protected MqttClient client;
	protected MqttConnectOptions connOpts;
	MemoryPersistence persistance = new MemoryPersistence();

	/**
	 * The constructor of the subscriber class.
	 * It makes an MQTT client with the given parameters.
	 * @param brokerUrl The broker url in "[protocol]://[host]:[port]" format.
	 * @param clientId The created client id.
	 */
	public Subscriber(String brokerUrl, String clientId) {
		try {
			client = new MqttClient(brokerUrl, clientId, persistance);
		} catch (MqttException e) {
			System.out.println("Could not create MQTTClient.");
		}
		connOpts = new MqttConnectOptions();
		connOpts.setCleanSession(true);
	}

	/**
	 * Sets the client callback parameter.
	 * @param callback
	 */
	public void setCallback(MqttCallback callback) {
		client.setCallback(callback);
	}

	/**
	 * This method connects the client to the MQTT broker.
	 */
	public void connect() {
		try {
			client.connect(connOpts);
		} catch (MqttException e) {
			System.out.println("Could not connect to MQTT broker.");
		}
	}

	/**
	 * This method subscribes the client to the given topic.
	 * @param topic
	 */
	public void subscribe(String topic) {
		try {
			client.subscribe(topic);
		} catch (MqttException e) {
			System.out.println("Could not subscribe to the topic. [" + topic + "]");
		}
	}

	/**
	 * This method unsubscribe the client from the given topic.
	 * @param topic
	 */
	public void unsubscribe(String topic) {
		try {
			client.unsubscribe(topic);
		} catch (MqttException e) {
			System.out.println("Could not unsubscribe from the topic. [" + topic + "]");
		}
	}
	
	/**
	 * Returns true, if the client is connected.
	 */
	public boolean isConnected() {
		if(client != null)
			return client.isConnected();
		else
			return false;
	}
	
	public void disconnect() {
		try {
			client.disconnect();
		} catch (MqttException e) {
			System.out.println("Could not disconnect from MQTT broker.");
		}
	}
	
	
}
