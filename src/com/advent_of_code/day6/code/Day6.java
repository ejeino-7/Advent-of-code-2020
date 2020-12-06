package com.advent_of_code.day6.code;

import java.util.ArrayList;
import java.util.List;

import com.advent_of_code.day0.util.input.InputParser;

public class Day6 {

	public static void main(String[] args) {
		List<String> lst = InputParser.toStringList(null, "day6_1", "", false);
		List<Declaration> decs = getDeclarations(lst, false);

		System.out.println("Part 1 - " + getSumOfAnswers(decs));

		lst = InputParser.toStringList(null, "day6_1");
		decs = getDeclarations(lst, true);

		System.out.println("Part 2 - " + getSumOfAnswers(decs));
	}

	public static long getSumOfAnswers(List<Declaration> decs) {
		long sum = 0L;

		for (Declaration d : decs) {
			sum += d.answerdQuestions();
		}

		return sum;
	}

	public static List<Declaration> getDeclarations(List<String> lst, boolean part2) {
		List<Declaration> d = new ArrayList<Declaration>();

		if (!part2) {
			for (String row : lst) {
				d.add(new Declaration(row));
			}
		} else {
			List<String> next = new ArrayList<String>();
			for(String row: lst) {
				if(row.equals("")) {
					d.add(new Declaration(next));
					next = new ArrayList<String>();
				} else {
					next.add(row);
				}
			}
			d.add(new Declaration(next));
		}

		return d;
	}
}
