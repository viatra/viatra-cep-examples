package com.incquerylabs.iot.pincodedemo.commons.model;

public class SensorData {
	
	private int x;
	private int y;
	private int z;
	private int tap;
	private long t;

	public SensorData(final int x, final int y, final int z, final int tap, final long t) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.tap = tap;
		this.t = t;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getZ() {
		return z;
	}
	public int getTap() {
		return tap;
	}
	public long getT() {
		return t;
	}
	
	@Override
	public String toString() {
		return "[ x=" + x + ", y=" + y + ", z=" + z + ", tap=" + tap + ", t=" + t + " ]";
	}
}
