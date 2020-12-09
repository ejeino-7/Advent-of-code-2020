package com.advent_of_code.day8.code;

import java.util.ArrayList;
import java.util.List;

public class ComputerPart2StoreRunnedInstructions extends Computer {

	private List<Integer> runnedInst;
	int runs = 0;
	public ComputerPart2StoreRunnedInstructions(List<String> inst) {
		super(inst, false);
		runnedInst = new ArrayList<Integer>();
	}

	@Override
	protected boolean executeNext() {

		if (!runnedInst.contains(this.instptr)) {
			runnedInst.add(this.instptr);
		}
		if(runs++ > this.inst.size()) {
			return false;
		}
		return super.executeNext();
	}

	public List<Integer> getRunnedInstructions() {
		return runnedInst;
	}
}
