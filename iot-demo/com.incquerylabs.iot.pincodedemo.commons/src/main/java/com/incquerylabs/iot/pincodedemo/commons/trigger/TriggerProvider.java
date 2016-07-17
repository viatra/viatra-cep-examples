package com.incquerylabs.iot.pincodedemo.commons.trigger;

import java.util.concurrent.atomic.AtomicBoolean;

import com.incquerylabs.iot.pincodedemo.commons.mqtt.Publisher;

public class TriggerProvider implements Runnable {
	
	AtomicBoolean sensorTriggerRunning = new AtomicBoolean(false);
	
	Publisher triggerPublisher;
	
	String brokerUrl;
	
	public TriggerProvider(String brokerUrl) {
		this.brokerUrl = brokerUrl;
	}
	
	public void run() {
		
		triggerPublisher = new Publisher(brokerUrl, "sensor_trigger_" + System.currentTimeMillis());
		triggerPublisher.connect();
		
		sensorTriggerRunning.set(true);;
		
		while(sensorTriggerRunning.get()) {
			if(triggerPublisher.isConnected())
				triggerPublisher.publish("sensor/trigger", new Long(System.currentTimeMillis()).toString());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void finish() {
		sensorTriggerRunning.set(false);
	}

}
