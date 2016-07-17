package com.incquerylabs.iot.pincodedemo.test;

import org.junit.Test;

public class CorrectCodeTest extends BaseTest {
	
	@Test
	public void correctCode() {
		
		// A - 1
		pushSensorAEvent(-250, 0, 0, 1);
		
		// B - 2
		pushSensorBEvent(0, 250, 0, 1);
		
		// C - 3
		pushSensorCEvent(0, -250, 0, 1);
		
		// D - 4
		pushSensorDEvent(0, 0, -250, 1);
		
		// Trigger initialize
		pushSensorAEvent(201, 0, 0, 1);
	}
}
