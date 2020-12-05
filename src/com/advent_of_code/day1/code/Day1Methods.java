package com.advent_of_code.day1.code;

import java.util.List;

public class Day1Methods {

	public static int productOfTwoThatEquals(List<Integer> ints, int shouldEqual) {
		for (int i = 0; i < ints.size(); i++) {
			for (int j = i; j < ints.size(); j++) {
				if (j > i) {
					if (ints.get(i) + ints.get(j) == shouldEqual) {
						return ints.get(i) * ints.get(j);
					}
				}
			}
		}
		return -1;
	}

	public static int productOfThreeThatEquals(List<Integer> ints, int shouldEqual) {
		for (int i = 0; i < ints.size(); i++) {
			for (int j = i; j < ints.size(); j++) {
				for (int k = j; k < ints.size(); k++) {
					if (ints.get(i) + ints.get(j) + ints.get(k) == shouldEqual) {
						return ints.get(i) * ints.get(j) * ints.get(k);
					}
				}

			}
		}
		return -1;
	}

}
