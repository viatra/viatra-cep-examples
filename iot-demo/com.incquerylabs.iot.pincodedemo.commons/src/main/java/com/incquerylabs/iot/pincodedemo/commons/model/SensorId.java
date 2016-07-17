package com.incquerylabs.iot.pincodedemo.commons.model;

public class SensorId {
	
	private String group;
	private String sensor;
	
	public SensorId(final String group, final String sensor) {
		super();
		this.group = group;
		this.sensor = sensor;
	}
	
	public String getGroup() {
		return group;
	}
	
	public String getSensor() {
		return sensor;
	}
	
	@Override
	public String toString() {
		return "[ " + group + "/" + sensor + " ]";
	}

}