package com.incquerylabs.iot.pincodedemo.commons.model;

public class SensorEvent {

	private SensorId id;

	private SensorData data;

	public SensorEvent(SensorId id, SensorData data) {
		super();
		this.id = id;
		this.data = data;
	}

	public SensorId getId() {
		return id;
	}

	public SensorData getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return String.format("%s : %s", id, data);
	}

}
