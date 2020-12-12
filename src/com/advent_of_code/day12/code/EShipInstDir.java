package com.advent_of_code.day12.code;

public enum EShipInstDir {
	E, W, N, S, F, L, R;
	
	
	public static EShipInstDir getByC(String s) {
		if(s.equals("E")) {
			return E;
		}
		if(s.equals("W")) {
			return W;
		}
		if(s.equals("N")) {
			return N;
		}
		if(s.equals("S")) {
			return S;
		}
		if(s.equals("F")) {
			return F;
		}
		if(s.equals("L")) {
			return L;
		}
			return R;
		
		
	}
}
