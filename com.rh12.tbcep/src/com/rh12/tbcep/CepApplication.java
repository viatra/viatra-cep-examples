package com.rh12.tbcep;

import java.util.Date;
import java.util.Map;
import java.text.*;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.eclipse.viatra.cep.core.api.engine.CEPEngine;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.streams.EventStream;
import org.junit.After;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.rh12.tbcep.vepl.CepFactory;
import com.rh12.tbcep.vepl.mapping.QueryEngine2ViatraCep;
import model.ModelFactory;
import model.Sensor;
import model.Vector;

public class CepApplication implements MqttCallback {

	// Logger
	private static final Logger logger = Logger.getLogger(CepApplication.class);
	
	// Connection strings 
	static final String HOST_ADDRESS = "192.168.0.31";
	static final String HOST_PORT = "1883";
	static final String DATA_TOPIC = "sensor/iosDevice/sensor0/data";
	
	// MQTT
	protected MqttClient client;
	protected MqttConnectOptions connOpts;
	MemoryPersistence persistance;
	
	// CEP
	private CEPEngine engine;
	private EventStream eventStream;
	
	// Model
	protected Resource resource;
	protected ResourceSet resourceSet;
	Sensor sensor;
	Vector sensorValues;
	
	// Pattern-Event mapping
	QueryEngine2ViatraCep mapping;

	public volatile boolean stopped = false;

	
	public CepApplication() throws MqttException {
		// create & connect MQTT Client
		persistance = new MemoryPersistence();
		client = new MqttClient("tcp://" + HOST_ADDRESS + ":" + HOST_PORT, "TBCEP_" + System.currentTimeMillis(), persistance);
		connOpts = new MqttConnectOptions();
		client.setCallback(this);
		client.connect(connOpts);
	}
	
	
	@Test
	public void test() throws MqttException, InterruptedException {
		// initialize CEP
		engine = CEPEngine.newEngine().eventContext(EventContext.CHRONICLE)
				.rules(CepFactory.getInstance().allRules()).prepare();
		logger.info("CEPEngine created");
		eventStream = engine.getStreamManager().newEventStream();
		
		// initialize Model
		sensor = ModelFactory.eINSTANCE.createSensor();
		sensorValues = ModelFactory.eINSTANCE.createVector();
		sensor.setValues(sensorValues);
		// create resource for Model
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("model", new XMIResourceFactoryImpl());
		resourceSet = new ResourceSetImpl();
		resource = resourceSet.createResource(URI.createURI("model/test.model"));
		resource.getContents().add(sensor);
		// map Model to EventStream
		mapping = QueryEngine2ViatraCep.register(resourceSet, eventStream);
		
		// subscribe to Topics
		client.subscribe(DATA_TOPIC);
		logger.info("Subscribed to '" + DATA_TOPIC + "' topic");
		
		logger.info("READY!");
		System.out.println("READY!");
		
		while(!stopped) {
			Thread.sleep(100);
		}
	}

	
	@After
	public void tearDown() throws MqttException {
		client.disconnect();
		mapping.dispose();
		resource = null;
		resourceSet = null;
	}

	
	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		switch (topic) {
			case DATA_TOPIC:
				// get values from message
				JsonParser parser = new JsonParser();
				JsonObject sensor = parser.parse(message.toString()).getAsJsonObject();
				Double x = sensor.get("x").getAsDouble();
				Double y = sensor.get("y").getAsDouble();
				Double z = sensor.get("z").getAsDouble();
				
				// update Model
				sensorValues.setX(x);
				sensorValues.setY(y);
				sensorValues.setZ(z);
				
				// print values
				//System.out.println(message.toString());
				
				// create Event
				eventStream.push(CepFactory.getInstance().createSensorDidUpdate_Event());
				
				break;
			default:
				break;
		}
	}
	
	
	@Override
	public void connectionLost(Throwable cause) {

	}
	

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		
	}
}
