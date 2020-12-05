package com.advent_of_code.day4.code;

import java.util.ArrayList;
import java.util.List;

import com.advent_of_code.day0.util.input.InputParser;

// Borde lära mig regex.. 
public class Day4 {

	public static void main(String[] args) {
		List<String> lst = InputParser.toStringList(null, "day4_1");

		List<Passport> psp = getPassports(lst);
		
		System.out.println("Valid passports   : " + countValidPassports(psp));
		System.out.println("Correct passports : " + countCorrectPassports(psp));

	}

	private static List<Passport> getPassports(List<String> lst) {
		List<Passport> psp = new ArrayList<>();

		String nextPassport = "";
		for (String s : lst) {
			if (s.equals("")) { // end of passport
				psp.add(new Passport(nextPassport));
				nextPassport = "";
			} else {
				nextPassport += " " + s;
			}
		}
		psp.add(new Passport(nextPassport));
		
		System.out.println("passports : " + psp.size());
		return psp;
	}

	public static int countValidPassports(List<Passport> psp) {
		int valids = 0;

		for (Passport ps : psp) {
			valids += ps.isValid() ? 1 : 0;
		}

		return valids;
	}

	public static int countCorrectPassports(List<Passport> psp) {
		int correct = 0;

		for (Passport ps : psp) {
			correct += ps.isCorrect() ? 1 : 0;
		}
		return correct;
	}

}
