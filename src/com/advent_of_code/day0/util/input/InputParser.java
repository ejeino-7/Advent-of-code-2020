package com.advent_of_code.day0.util.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputParser {

	private static String DEFAULT_FOLDER = System.getProperty("user.dir") + "/input/";

	public static List<String> toStringList(String dir, String filename) {
		List<String> lst = new ArrayList<String>();
		if(dir == null) {
			dir = DEFAULT_FOLDER;
		}
		String fileURL = String.format("%s%s", dir, filename);
		File f = new File(fileURL);

		try {
			Scanner reader = new Scanner(f);

			while (reader.hasNext()) {
				String nextLine = reader.nextLine();
				lst.add(nextLine);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}

		return lst;
	}
	
	public static List<String> toStringList(String dir, String filename, String separator, boolean useSpace) {
		List<String> lst = new ArrayList<String>();
		if(dir == null) {
			dir = DEFAULT_FOLDER;
		}
		String fileURL = String.format("%s%s", dir, filename);
		File f = new File(fileURL);

		try {
			Scanner reader = new Scanner(f);
			String tmp = "";
			while (reader.hasNext()) {
				String nextLine = reader.nextLine();
				if(nextLine.equals(separator)) {
					lst.add(tmp);
					tmp = "";
				} else {
					tmp += useSpace ? " " : "" + nextLine;
				}
				
			}
			lst.add(tmp);
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}

		return lst;
	}
	
	public static String[][] toStringGrid(String dir, String filename) {
		
		List<String> lst = toStringList(dir, filename);
		String[][] grid = new String[lst.size()][lst.get(0).length()];
		for(int i = 0; i < lst.size(); i++) {
			for(int j = 0; j < lst.get(0).length(); j++) {
				grid[i][j] = lst.get(i).charAt(j) + "";
			}
		}
		return grid;
	}

	
	public static List<Integer> toIntegerList(String dir, String filename, EInputType type) {
		if(dir == null) {
			dir = DEFAULT_FOLDER;
		}
		List<Integer> lst = new ArrayList<>();

		File f = new File(String.format("%s%s", dir, filename));
		try {
			Scanner reader;
			reader = new Scanner(f);
		switch (type) {
		case EACH:
		
			while (reader.hasNext()) {
				lst.add(reader.nextInt());
			}
			break;

		case BY_LINE:
		
			while (reader.hasNext()) {
				String nextLine = reader.nextLine();
				lst.add(Integer.parseInt(nextLine));
			}
			
			break;
			
		default:
			break;
		}
		reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return lst;
	}

}
