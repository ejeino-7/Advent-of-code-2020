package com.advent_of_code.day8.code;

public enum EInstuction {

	jmp("jmp"), acc("acc"), nop("nop"), UNDEFINED("");

	private final String name;

	private EInstuction(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static EInstuction getByName(String name) {
		if (name.equals(jmp.getName())) {
			return jmp;
		} else if (name.equals(acc.getName())) {
			return acc;
		} else if (name.equals(nop.getName())) {
			return nop;
		} else {
			return UNDEFINED;
		}
	}

}
