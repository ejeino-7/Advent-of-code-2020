package com.advent_of_code.day11.code;

import com.advent_of_code.day0.util.input.InputParser;

/**
 * @author Seagate_os
 *
 */
public class Day11 {

	public static void main(String[] args) {
		String[][] lst = InputParser.toStringGrid(null, "day11_1");
		
		SeatGrid w = new SeatGrid(lst);
		while(!w.runRound(4, false));
		System.out.println("Part 1 : " + w.getOcupied());
		
		SeatGrid w2 = new SeatGrid(lst);
		while(!w2.runRound(5, true));
		System.out.println("Part 2 : " + w2.getOcupied());
			
	}
}
