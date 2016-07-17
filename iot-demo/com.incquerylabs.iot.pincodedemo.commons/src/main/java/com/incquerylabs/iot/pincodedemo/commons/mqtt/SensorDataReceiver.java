package com.incquerylabs.iot.pincodedemo.commons.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.google.gson.Gson;
import com.incquerylabs.iot.pincodedemo.commons.exception.Sensor2CodeConvertException;
import com.incquerylabs.iot.pincodedemo.commons.model.Sensor2CodeConverter;
import com.incquerylabs.iot.pincodedemo.commons.model.SensorData;
import com.incquerylabs.iot.pincodedemo.commons.model.SensorEvent;
import com.incquerylabs.iot.pincodedemo.commons.model.SensorId;
import com.incquerylabs.iot.pincodedemo.commons.stream.IEventStreamProvider;

public class SensorDataReceiver implements MqttCallback {

	private IEventStreamProvider stream;
	
	private Gson gson;
	
	public SensorDataReceiver(IEventStreamProvider session) {
		this.stream = session;
		this.gson = new Gson();
	}

	public void connectionLost(Throwable cause) {
		// TODO: implement reconnect loop
	}

	public void messageArrived(String topic, MqttMessage message) {
		
		// Parse sensor data and get identification from topic
		String[] topicSections = topic.split("/");
		SensorId sensorId = new SensorId(topicSections[1], topicSections[2]);
		SensorData sensorData = gson.fromJson(message.toString(), SensorData.class);
		
		// Create new sensor event and push it to the stream
		try {
			if(sensorData.getTap() > 0)
				stream.push(Sensor2CodeConverter.convert(new SensorEvent(sensorId, sensorData)));
			else
				System.out.println("No tap data!");
		} catch (Sensor2CodeConvertException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public void deliveryComplete(IMqttDeliveryToken token) {}
	
}
