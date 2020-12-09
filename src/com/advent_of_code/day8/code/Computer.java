package com.advent_of_code.day8.code;

import java.util.List;

public class Computer {

	private long accumulator = 0L;
	protected List<String> inst;
	protected int instptr = 0;
	private boolean onlySingleExecPerInst;
	
	private boolean didTerminate;
	
	public Computer(List<String> inst, boolean onlySingleExecPerInst) {
		this.inst = inst;
		this.onlySingleExecPerInst = onlySingleExecPerInst;
		didTerminate = false;
	}
	protected boolean executeNext() {
		boolean ok = true;
		if(instptr >= inst.size()) {
			didTerminate = true;
			return false;
		}
		String ins = inst.get(instptr);
		EInstuction ei = EInstuction.getByName(ins.split(" ")[0]);
		String val = ins.split(" ")[1];
		int value = val.charAt(0) == '+' ? Integer.parseInt(val.subSequence(1, val.length()).toString()) : Integer.parseInt(val.subSequence(1, val.length()).toString()) * -1; 
		
		if(onlySingleExecPerInst) {
			inst.set(instptr, "undef +0");
		}
		
		switch (ei) {
		case jmp:
			instptr += value;
			break;
		case acc:
			updateAccumulator(value);
			instptr++;
			break;
		case nop:
			instptr++;
			break;
		default:
			ok = false;
			break;
		}
		
		return ok;
	}
	
	public long run() {
		while(executeNext());
		
		return accumulator;
		
	}
	
	public boolean didTerminate() {
		return didTerminate;
	}
	
	private void updateAccumulator(int value) {
		accumulator += value;
	}
}
