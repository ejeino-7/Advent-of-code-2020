package com.advent_of_code.day12.code;

import java.util.List;

import com.advent_of_code.day0.util.input.InputParser;

public class Day12 {

	public static void main(String[] args) {
		List<String> lst = InputParser.toStringList(null, "day12_1");
		
		Ship ship = new Ship();
		for(String s : lst) {
			ship.runInst(s);
		}
		
		System.out.println("Part 1 : " + ship.getManhattanDistance());
		
		Ship2 ship2 = new Ship2();
		for(String s : lst) {
			ship2.runInst(s);
		}
		
		System.out.println("Part 2 : " + ship2.getManhattanDistance());
		
		
	}
}
