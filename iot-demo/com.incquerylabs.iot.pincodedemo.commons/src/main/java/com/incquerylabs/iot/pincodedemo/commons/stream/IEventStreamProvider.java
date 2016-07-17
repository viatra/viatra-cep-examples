package com.incquerylabs.iot.pincodedemo.commons.stream;

import com.incquerylabs.iot.pincodedemo.commons.model.CodeEvent;

public interface IEventStreamProvider {
	
	public void push(CodeEvent event);
	
	public void dispose();

}
