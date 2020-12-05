package com.advent_of_code.day3.code;
import java.util.List;

import com.advent_of_code.day0.util.input.InputParser;

public class Day3 {

	private static final char TREE = '#';
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> lst = InputParser.toStringList(null, "day3_1");
		
		System.out.println("PART 1");
		System.out.println("Trees - " + countThrees(lst, 3, 1 ));
		System.out.println("----------- \nPART2");
		
		long r  = countThrees(lst, 1, 1);
		r *= countThrees(lst, 3, 1);
		r *= countThrees(lst, 5, 1);
		r *= countThrees(lst, 7, 1);
		r *= countThrees(lst, 1, 2);
		System.out.println("Trees Muliplied - " + r);
		
		
	}
	
	public static int countThrees(List<String> lst, int xSteps, int ySteps) {
		int trees = 0;
		int xPtr = 0;
		for(int i = 0; i < lst.size(); i += ySteps) {
			if(lst.get(i).charAt(xPtr) == TREE) {
				trees ++;
			}
			xPtr += xSteps;
			xPtr = xPtr % lst.get(i).length();
		}
		
		return trees;
	}
}
