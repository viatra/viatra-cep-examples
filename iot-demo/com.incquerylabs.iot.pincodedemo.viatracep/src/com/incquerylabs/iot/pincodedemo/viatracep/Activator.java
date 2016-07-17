package com.incquerylabs.iot.pincodedemo.viatracep;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.incquerylabs.iot.pincodedemo.commons.PinCodeManager;
import com.incquerylabs.iot.pincodedemo.viatracep.stream.ViatraCepEventStreamProvider;

public class Activator implements BundleActivator {

	private static BundleContext context;
	
	public final static String defaultBrokerAddress = "tcp://127.0.0.1:1883";
	
	PinCodeManager demo;
	
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		demo = new PinCodeManager(new ViatraCepEventStreamProvider(), defaultBrokerAddress);
		demo.start();
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		if(demo != null)
			demo.stop();
	}

}
