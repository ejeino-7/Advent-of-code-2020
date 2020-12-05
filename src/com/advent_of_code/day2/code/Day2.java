package com.advent_of_code.day2.code;

import java.util.List;

import com.advent_of_code.day0.util.input.InputParser;

public class Day2 {
	public static void main(String[] args) {
		
		List<String> lst = InputParser.toStringList(null, "day2_1");
	
		System.out.println("Part 1 - "+ countValidPasswordsPart1(lst));
		System.out.println("Part 2 - "+ countValidPasswordsPart2(lst));
	}
	
	
	public static int countValidPasswordsPart1(List<String> lst) {
		int valids = 0;
		
		for(String str : lst) {
			String[] splt = str.split(": ");
			String password = splt[1];
			String cchar = splt[0].split(" ")[1];
			int min = Integer.parseInt(splt[0].split("-")[0]);
			int max = Integer.parseInt(splt[0].split("-")[1].split(" ")[0]);
			
			int appears = 0;
			for(int i = 0; i < password.length(); i++) {
				if(password.charAt(i) == cchar.charAt(0)) {
					appears++;
				}
			}
			if(appears >= min && appears <= max) {
				valids++;
			}
		}
		
		
		return valids;
	}
	
	public static int countValidPasswordsPart2(List<String> lst) {
		int valids = 0;
		
		for(String str : lst) {
			String[] splt = str.split(": ");
			String password = splt[1];
			char cchar = splt[0].split(" ")[1].charAt(0);
			int lp = Integer.parseInt(splt[0].split("-")[0]) -1 ;
			int hp = Integer.parseInt(splt[0].split("-")[1].split(" ")[0]) -1;
			
			int appears = 0;
			if(password.charAt(lp) == cchar) {
				appears++;
			}
			if(password.charAt(hp) == cchar) {
				appears++;
			}
			if(appears == 1) {
				valids++;
			}
		}
		
		
		return valids;
	}
	
}
