package com.incquerylabs.iot.pincodedemo.drools;

import com.incquerylabs.iot.pincodedemo.commons.PinCodeManager;
import com.incquerylabs.iot.pincodedemo.drools.stream.StreamEntryPointProvider;

public class Application {

	public static String defaultBrokerAddress = "tcp://127.0.0.1:1883";

	public static void main(String[] args) {
		
		final PinCodeManager demo = new PinCodeManager(new StreamEntryPointProvider(), defaultBrokerAddress);
		
		demo.start();
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
		       demo.stop();
		    }
		});
		
	}

}
