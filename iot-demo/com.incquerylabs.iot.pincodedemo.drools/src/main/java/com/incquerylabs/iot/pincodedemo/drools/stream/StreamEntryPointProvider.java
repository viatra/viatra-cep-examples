package com.incquerylabs.iot.pincodedemo.drools.stream;

import java.util.concurrent.atomic.AtomicReference;

import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.EntryPoint;

import com.incquerylabs.iot.pincodedemo.commons.model.CodeEvent;
import com.incquerylabs.iot.pincodedemo.commons.stream.IEventStreamProvider;

public class StreamEntryPointProvider implements IEventStreamProvider {

	AtomicReference<KieSession> kieSession;
	
	AtomicReference<EntryPoint> stream;
	
	public final static String CODE_STREAM = "CodeStream";
	
	public StreamEntryPointProvider() {

		KieServices kieServices = KieServices.Factory.get();

		KieContainer kieContainer = kieServices.getKieClasspathContainer();
		KieBaseConfiguration kieBaseConf = kieServices.newKieBaseConfiguration();
		kieBaseConf.setOption(EventProcessingOption.STREAM);
		
		KieBase kieBase = kieContainer.newKieBase(kieBaseConf);
		
		kieSession = new AtomicReference<KieSession>(kieBase.newKieSession());
		
		stream = new AtomicReference<EntryPoint>(kieSession.get().getEntryPoint( CODE_STREAM ));
	}
	
	@Override
	public void push(CodeEvent object) {
		stream.get().insert(object);
		kieSession.get().fireAllRules();
	}
	
	@Override
	public void dispose() {
		kieSession.get().dispose();
	}
}
