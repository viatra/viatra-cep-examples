package com.incquerylabs.iot.pincodedemo.commons.model;

public class CodeEvent {
	
	CodeSource source;
	
	int value;

	public CodeEvent(CodeSource source, int value) {
		super();
		this.source = source;
		this.value = value;
	}
	
	public CodeSource getSource() {
		return source;
	}

	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return "[" + source.name() + ", " + value + "]";
	}

}
