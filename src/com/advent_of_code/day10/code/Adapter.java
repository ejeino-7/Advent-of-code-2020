package com.advent_of_code.day10.code;

public class Adapter {

	private boolean to1;
	private boolean to2;
	private boolean to3;
	
	private long routes;

	public Adapter(boolean to1, boolean to2, boolean to3, long routes) {
		this.to1 = to1;
		this.to2 = to2;
		this.to3 = to3;
		this.routes = routes;
	}

	public Adapter(boolean to1, boolean to2, boolean to3) {
		this.to1 = to1;
		this.to2 = to2;
		this.to3 = to3;
	}

	
	public Adapter() {
	}

	public boolean isTo1() {
		return to1;
	}

	public void setTo1(boolean to1) {
		this.to1 = to1;
	}

	public boolean isTo2() {
		return to2;
	}

	public void setTo2(boolean to2) {
		this.to2 = to2;
	}

	public boolean isTo3() {
		return to3;
	}

	public void setTo3(boolean to3) {
		this.to3 = to3;
	}

	public long getRoutes() {
		return routes;
	}

	public void setRoutes(long routes) {
		this.routes = routes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Adapter [to1=");
		builder.append(to1);
		builder.append(", to2=");
		builder.append(to2);
		builder.append(", to3=");
		builder.append(to3);
		builder.append(", routes=");
		builder.append(routes);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
