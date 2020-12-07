package com.advent_of_code.day7.code;

import java.util.List;
import java.util.Map;

import com.advent_of_code.day0.util.input.InputParser;

public class Day7 {

	public static void main(String[] args) {
		List<String> lst = InputParser.toStringList(null, "day7_1");
		processBags(lst);
		System.out.println("Part 1 : " + getAmontOfBagsThatCouldContain("shiny gold"));
		System.out.println("Part 2 : " + Bag.getBagByName("shiny gold").getAmountOfBagsContained());
	}
	
	
	
	public static void processBags(List<String> lst) {
		for(String s : lst) {
			String b1 = s.split(" bags contain")[0];
			Bag b = Bag.getBagByName(b1);
			
			String[] conts = s.split(" bags contain ")[1].split(" ");
			
			for(int i = 0; i < conts.length; i+= 4) {
				if(conts[i].equals("no")) {
					continue;
				}
				b.addContainedBag(Bag.getBagByName(conts[i+1] + " " + conts[i+2]), Integer.parseInt(conts[i]));
			}
		}
	}
	
	static int count = 0;
	public static int getAmontOfBagsThatCouldContain(String name) {
		count = 0;
		Map<String, Bag> bags = Bag.getBagMap();
		bags.forEach((k, v) -> {
			if(v.doBagContain(name)) {
				count++;
			}
		});
		return count;
	}
}
