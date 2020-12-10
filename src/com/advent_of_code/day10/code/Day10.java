package com.advent_of_code.day10.code;

import java.util.ArrayList;
import java.util.List;

import com.advent_of_code.day0.util.input.EInputType;
import com.advent_of_code.day0.util.input.InputParser;

public class Day10 {
	public static void main(String[] args) {
		List<Integer> lst = InputParser.toIntegerList(null, "day10_1", EInputType.BY_LINE);
		lst.sort(null);
		System.out.println("part 1 : " + part1(lst));

		List<Adapter> adps = getAdapters(lst);
		setRoutes(adps);

		System.out.println("part 2 : " + part2(adps));

	}

	public static long part1(List<Integer> lst) {
		int ons = 1;
		int trs = 1;
		for (int i = 0; i < lst.size() - 1; i++) {
			if (lst.get(i) == lst.get(i + 1) - 1) {
				ons++;
			} else if (lst.get(i) == lst.get(i + 1) - 3) {
				trs++;
			} else if (lst.get(i) < lst.get(i + 1) - 3) {
				break;
			}
		}

		return ons * trs;
	}

	public static long part2(List<Adapter> lst) {

		return lst.get(0).getRoutes()
				+ (lst.get(0).isTo1() ? lst.get(1).getRoutes() : 0)
				+ (lst.get(0).isTo2() ? lst.get(2).getRoutes() : 0);
	}

	public static void setRoutes(List<Adapter> adps) {
		adps.get(adps.size() - 1).setRoutes(1);
		for (int i = adps.size() - 1; i >= 0; i--) {
			Adapter a = adps.get(i);
			if (a.isTo1()) {
				a.setRoutes(a.getRoutes() + adps.get(i + 1).getRoutes());
			}
			if (a.isTo2()) {
				a.setRoutes(a.getRoutes() + adps.get(i + 2).getRoutes());
			}
			if (a.isTo3()) {
				a.setRoutes(a.getRoutes() + adps.get(i + 3).getRoutes());
			}
		}
	}

	public static List<Adapter> getAdapters(List<Integer> lst) {
		List<Adapter> adps = new ArrayList<Adapter>(lst.size());

		for (int i = 0; i < lst.size(); i++) {
			Adapter a = new Adapter();

			if (i < lst.size() - 3 && lst.get(i + 3) - lst.get(i) <= 3) {
				a.setTo3(true);
			}
			if (i < lst.size() - 2 && lst.get(i + 2) - lst.get(i) <= 3) {
				a.setTo2(true);
			}
			if (i < lst.size() - 1 && lst.get(i + 1) - lst.get(i) <= 3) {
				a.setTo1(true);
			}
			adps.add(a);
		}

		return adps;
	}
}
