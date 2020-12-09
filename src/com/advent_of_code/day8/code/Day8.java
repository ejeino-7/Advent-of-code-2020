package com.advent_of_code.day8.code;

import java.util.Arrays;
import java.util.List;

import com.advent_of_code.day0.util.input.InputParser;

public class Day8 {

	public static void main(String[] args) {
		List<String> lst = InputParser.toStringList(null, "day8_1");
		System.out.println("Part 1 : " + new Computer(lst, true).run());

		lst = InputParser.toStringList(null, "day8_1");
		ComputerPart2StoreRunnedInstructions comp = new ComputerPart2StoreRunnedInstructions(lst);
		comp.run();
		List<Integer> ri = comp.getRunnedInstructions();
		long res = 0; 
		for (int j = ri.size() - 1; j >= 0; j--) {
			int i = ri.get(j);
			lst = InputParser.toStringList(null, "day8_1");
			if (lst.get(i).contains("jmp")) {
				lst.set(i, lst.get(i).replace("jmp", "nop"));

				Computer computer = new Computer(lst, true);
				res = computer.run();
				if (computer.didTerminate()) {
					break;
				}
			} else if (lst.get(i).contains("nop")) {
				lst.set(i, lst.get(i).replace("nop", "jmp"));
				Computer computer = new Computer(lst, true);
				res = computer.run();
				if (computer.didTerminate()) {
					break;
				}
			}
		}

		System.out.println("Part 2 : " + res);
	}

}
