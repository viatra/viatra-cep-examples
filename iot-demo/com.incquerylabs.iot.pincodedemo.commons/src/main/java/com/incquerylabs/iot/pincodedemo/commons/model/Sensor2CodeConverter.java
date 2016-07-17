package com.incquerylabs.iot.pincodedemo.commons.model;

import com.google.common.collect.Range;
import com.incquerylabs.iot.pincodedemo.commons.exception.Sensor2CodeConvertException;

public class Sensor2CodeConverter {
	
	static Range<Integer> valueRange = Range.closed(0, 5);
	
	static int stateTreshold = 200;
	
	public static CodeEvent convert(SensorEvent sensorEvent) throws Sensor2CodeConvertException {
		CodeSource codeSource = mapSource(sensorEvent.getId());
		int codeValue = mapValue(sensorEvent.getData());
		if(codeSource != null && valueRange.contains(codeValue)) {
			return new CodeEvent(codeSource, codeValue);
		} else throw new Sensor2CodeConvertException(sensorEvent);
	}
	
	private static CodeSource mapSource(SensorId sensorId) {
		switch(sensorId.getSensor()) {
			case "HEAD"	: return CodeSource.A; 
			case "LH"	: return CodeSource.B; 
			case "RH"	: return CodeSource.C;
			case "LL"	: return CodeSource.D;
		}
		return null;
	}
	
	private static int mapValue(SensorData sensorData) {
		
		ValueState xState = getState(sensorData.getX());
		ValueState yState = getState(sensorData.getY());
		ValueState zState = getState(sensorData.getZ());
		
		if(ValueState.isBase(xState) && ValueState.isBase(yState) && ValueState.isHigh(zState)) // Z HIGH
			return 0;
		
		if(ValueState.isLow(xState) && ValueState.isBase(yState) && ValueState.isBase(zState))	// X LOW
			return 1;
		
		if(ValueState.isBase(xState) && ValueState.isHigh(yState) && ValueState.isBase(zState))	// Y HIGH
			return 2;
		
		if(ValueState.isBase(xState) && ValueState.isLow(yState) && ValueState.isBase(zState))	// Y LOW
			return 3;
		
		if(ValueState.isBase(xState) && ValueState.isBase(yState) && ValueState.isLow(zState))  // Z LOW
			return 4;
		
		if(ValueState.isHigh(xState) && ValueState.isBase(yState) && ValueState.isBase(zState)) // X HIGH
			return 5;
		
		return -1;
	}
	
	private static ValueState getState(int value) {
		if(value <= -stateTreshold)
			return ValueState.LOW;
		if(value >= stateTreshold)
			return ValueState.HIGH;
		return ValueState.BASE;
	}
	
	enum ValueState {
		HIGH,
		LOW,
		BASE;
		
		static public boolean isHigh(ValueState state) {
			return state == HIGH;
		}
		
		static public boolean isLow(ValueState state) {
			return state == LOW;
		}
		
		static public boolean isBase(ValueState state) {
			return state == BASE;
		}
	}
}
