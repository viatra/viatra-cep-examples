package com.incquerylabs.iot.pincodedemo.test;

import org.junit.Ignore;
import org.junit.Test;

public class IncorrectCodeTest extends BaseTest {
	
	@Test
	@Ignore
	public void incorrectCode1() {
		// B - 1
		pushSensorBEvent(-250, 0, 0, 1);
				
		// A - 2
		pushSensorAEvent(0, 250, 0, 1);
				
		// C - 3
		pushSensorCEvent(0, -250, 0, 1);
				
		// D - 4
		pushSensorDEvent(0, 0, -250, 1);
	}
	
	@Test
	public void incorrectCode2() {
		
		// A - 1
		pushSensorAEvent(-250, 0, 0, 1);
				
		// B - 2
		pushSensorBEvent(0, 250, 0, 1);
		
		// B - 2
		pushSensorBEvent(0, 250, 0, 1);
		
		// C - 3
		pushSensorCEvent(0, -250, 0, 1);
				
		// D - 4
		pushSensorDEvent(0, 0, -250, 1);
		
	}
}
