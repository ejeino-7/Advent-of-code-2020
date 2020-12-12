package com.advent_of_code.day12.code;

public enum EShipDir {
	N(0), S(180), E(90), W(270);
	
	private final int v;

	
	private EShipDir(int v) {
		this.v = v;
	}

	

	public int getV() {
		return v;
	}


	public static EShipDir getByValue(int val) {
		val = val % 360;
		if(val == -90) {
			val = 270;
		}
		if(val == -180) {
			val = 180;
		}
		if(val == -270) {
			val = 90;
		}
		
		if(val == 180) {
			return S;
		} 
		if(val == 90) {
			return E;
		}
		if(val == 270) {
			return W;
		}
		if(val == 0 || val == 360) {
			return N;
		}
		System.err.println("ERROR ERROR, VAL " + val);
		return N;
	}
	

	public static EShipDir rotate(int am, EShipDir prev, String dir) {
		int mul = dir.equals("R") ? 1 : -1;
		
		return EShipDir.getByValue(prev.getV() + (mul * am));
		
	}
}
