package com.incquerylabs.iot.pincodedemo.test;

import org.junit.After;
import org.junit.Before;

import com.google.gson.Gson;
import com.incquerylabs.iot.pincodedemo.commons.model.SensorData;
import com.incquerylabs.iot.pincodedemo.commons.mqtt.Publisher;

public class BaseTest {
	
	public static String defaultBrokerAddress = "tcp://127.0.0.1:1883";
	
	Publisher publisher;
	
	public final static String sensorTopic = "sensor/player4/%s/data";
	
	Gson gson;
	
	@Before
	public void setUp() {
		gson = new Gson();
		publisher = new Publisher(defaultBrokerAddress, "test_publisher" + System.nanoTime());
		publisher.connect();
	}
	
	@After
	public void tearDown() {
		publisher.disconnect();
	}
	
	protected void pushSensorAEvent(int x, int y, int z, int tap) {
		publisher.publish(String.format(sensorTopic, "HEAD"), gson.toJson(new SensorData(x, y, z, tap, System.currentTimeMillis())));
	}
	
	protected void pushSensorBEvent(int x, int y, int z, int tap) {
		publisher.publish(String.format(sensorTopic, "LH"), gson.toJson(new SensorData(x, y, z, tap, System.currentTimeMillis())));
	}
	
	protected void pushSensorCEvent(int x, int y, int z, int tap) {
		publisher.publish(String.format(sensorTopic, "RH"), gson.toJson(new SensorData(x, y, z, tap, System.currentTimeMillis())));
	}
	
	protected void pushSensorDEvent(int x, int y, int z, int tap) {
		publisher.publish(String.format(sensorTopic, "LL"), gson.toJson(new SensorData(x, y, z, tap, System.currentTimeMillis())));
	}
	
	
}
