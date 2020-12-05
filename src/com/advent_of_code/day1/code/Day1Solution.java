package com.advent_of_code.day1.code;

import java.util.List;

import com.advent_of_code.day0.util.input.EInputType;
import com.advent_of_code.day0.util.input.InputParser;

public class Day1Solution {

	public static void main(String[] args) {

		List<Integer> ints = InputParser.toIntegerList(null, "day1_1", EInputType.BY_LINE);

		System.out.println("Part 1 - " + Day1Methods.productOfTwoThatEquals(ints, 2020));
		System.out.println("Part 2 - " + Day1Methods.productOfThreeThatEquals(ints, 2020));

	}

}
