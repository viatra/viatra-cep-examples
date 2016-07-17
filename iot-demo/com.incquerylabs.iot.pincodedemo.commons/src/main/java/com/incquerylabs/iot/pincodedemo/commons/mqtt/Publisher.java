package com.incquerylabs.iot.pincodedemo.commons.mqtt;

import java.io.UnsupportedEncodingException;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Publisher {
	
	protected MqttClient client;
	protected MqttConnectOptions connOpts;
	MemoryPersistence persistance = new MemoryPersistence();
	
	/**
	 * The constructor of the publisher class.
	 * It makes an MQTT client with the given parameters.
	 * @param brokerUrl The broker url in "[protocol]://[host]:[port]" format
	 * @param clientId The created client id.
	 */
	public Publisher(String brokerUrl, String clientId) {
		try {
			client = new MqttClient(brokerUrl, clientId, persistance);
		} catch (MqttException e) {
			System.out.println("Could not create MQTTClient.");
		}
		connOpts = new MqttConnectOptions();
		connOpts.setCleanSession(true);
	}

	/**
	 * This method connects the client to MQTT broker with the
	 * previously made connection options.
	 */
	public void connect() {
		try {
			client.connect(connOpts);
		} catch (MqttException e) {
			System.out.println("Could not connect to MQTT broker.");
		}
	}

	/**
	 * This method publish a string message to the given topic
	 * with the given quality of service.
	 * @param topic
	 * @param payload
	 * @param qos
	 */
	public void publish(String topic, String payload, int qos) {
		try {
			publish(topic, payload.getBytes("UTF-8"), qos);
		} catch (UnsupportedEncodingException e) {
			System.out.println("Could not encode message. [" + payload + "]");
		}
	}
	
	/**
	 * This method publish a string message to the given topic
	 * with default (1) quality of service.
	 * @param topic
	 * @param payload
	 */
	public void publish(String topic, String payload) {
		this.publish(topic, payload.getBytes());
	}
	
	/**
	 * This method publish a byte array to the given topic
	 * with the given quality of service.
	 * @param topic
	 * @param payload
	 * @param qos
	 */
	public void publish(String topic, byte[] payload, int qos) {
		MqttMessage message = new MqttMessage(payload);
		message.setQos(qos);
		message.setRetained(false);
		try {
			client.publish(topic, message);
		} catch (MqttException e) {
			System.out.println("Could not publish MQTT message.");
		}
	}
	
	/**
	 * This method publish a byte array to the given topic
	 * with default (1) quality of service.
	 * @param topic
	 * @param payload
	 */
	public void publish(String topic, byte[] payload) {
		this.publish(topic, payload, 0);
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
	
	/**
	 * This method disconnects the client from MQTT broker.
	 */
	public void disconnect() {
		try {
			client.disconnect();
		} catch (MqttException e) {
			System.out.println("Could not disconnect from MQTT broker.");
		}
	}
	
}
