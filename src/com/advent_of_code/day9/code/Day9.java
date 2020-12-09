package com.advent_of_code.day9.code;

import java.util.List;

import com.advent_of_code.day0.util.input.InputParser;

public class Day9 {

	public static void main(String[] args) {
		List<Long> lst = InputParser.toLongList(null, "day9_1");
		long firstInvalid = findFirstInvalid(lst, 25);
		System.out.println("Part 1 : " + firstInvalid);

		int endPos = lst.indexOf(firstInvalid);
		System.out.println("Part 2 : " + findNumbersSumsTo(lst, firstInvalid, endPos));
	}

	public static long findNumbersSumsTo(List<Long> lst, long value, int endPos) {

		for (int i = 0; i < endPos; i++) {
			long sum = 0L;
			for (int j = i; j < endPos && sum <= value; j++) {
				sum += lst.get(j);
				if (sum == value) {
					return getSumOfBiggestAndSmallest(lst.subList(i, j + 1));
				}
			}
		}
		return -1;
	}

	public static long getSumOfBiggestAndSmallest(List<Long> lst) {
		long min = lst.get(0);
		long max = 0;
		for (long l : lst) {
			min = l < min ? l : min;
			max = l > max ? l : max;
		}
		return min + max;
	}

	public static long findFirstInvalid(List<Long> lst, int skip) {
		for (int i = skip; i < lst.size(); i++) {
			if (!isSumOfAny25Before(lst, i)) {
				return lst.get(i);
			}
		}
		return 0L;
	}

	public static boolean isSumOfAny25Before(List<Long> lst, int pos) {
		long value = lst.get(pos);

		for (int i = pos - 1; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {
				if (lst.get(i) + lst.get(j) == value) {
					return true;
				}
			}
		}
		return false;

	}
}
