package com.incquerylabs.iot.pincodedemo.commons;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.incquerylabs.iot.pincodedemo.commons.mqtt.SensorDataReceiver;
import com.incquerylabs.iot.pincodedemo.commons.mqtt.Subscriber;
import com.incquerylabs.iot.pincodedemo.commons.stream.IEventStreamProvider;
import com.incquerylabs.iot.pincodedemo.commons.trigger.TriggerProvider;

public class PinCodeManager {
	
	private IEventStreamProvider stream;
	
	private String brokerAddress;
	
	private ExecutorService executor;
	
	private Subscriber sensorDataSubscriber;
	
	private TriggerProvider trigger;
	
	public PinCodeManager(IEventStreamProvider stream, String brokerAddress) {
		this.stream = stream;
		this.brokerAddress = brokerAddress;
	}
	
	public void start() {
		
		// create new thread pool
		executor = Executors.newCachedThreadPool();
		
		sensorDataSubscriber = new Subscriber(brokerAddress, "sensor_data_receiver_drools");
		sensorDataSubscriber.setCallback(new SensorDataReceiver(stream));
		
		// Connect to broker
		sensorDataSubscriber.connect();
		
		// Subscribe to sensor topics
		sensorDataSubscriber.subscribe("sensor/player4/HEAD/data");
		sensorDataSubscriber.subscribe("sensor/player4/RL/data");
		sensorDataSubscriber.subscribe("sensor/player4/LL/data");
		sensorDataSubscriber.subscribe("sensor/player4/RH/data");
		sensorDataSubscriber.subscribe("sensor/player4/LH/data");
		
		// start sensor trigger
		trigger = new TriggerProvider(brokerAddress);
		executor.execute(trigger);
	}
	
	public void stop() {
		trigger.finish();
	    sensorDataSubscriber.disconnect();
	    stream.dispose();
	}
	
}
