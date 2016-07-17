package com.incquerylabs.iot.pincodedemo.commons.exception;

import com.incquerylabs.iot.pincodedemo.commons.model.SensorEvent;

public class Sensor2CodeConvertException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private final static String MESSAGE = "Unable to convert sensor event to code event: %s ";
	
	public Sensor2CodeConvertException(SensorEvent event) {
		super(String.format(MESSAGE, event));
	}
}
