package com.advent_of_code.day6.code;

import java.util.HashMap;
import java.util.List;

public class Declaration {

	private String answerd;

	public Declaration(String row) {
		answerd = "";
		for (char c : row.toCharArray()) {
			if (!answerd.contains("" + c)) {
				answerd += c;
			}
		}
	}

	public Declaration(List<String> rows) {
		String ans = "";
		for (String s : rows) {
			String tmp = "";
			for (char c : s.toCharArray()) {
				if (!tmp.contains("" + c)) { // remove duplicated on same line
					tmp += c;
				}
			}
			ans += tmp;
		}

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (char c : ans.toCharArray()) { // Count occur
			if (map.containsKey("" + c)) {
				map.put("" + c, map.get("" + c).intValue() + 1);
			} else {
				map.put("" + c, 1);
			}
		}
		answerd = "";
		map.forEach((k, v) -> {
			if (v == rows.size()) {
				answerd += k;
			}
		});
	}

	public int answerdQuestions() {
		return answerd.length();
	}

}
