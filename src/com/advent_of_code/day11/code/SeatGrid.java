package com.advent_of_code.day11.code;

import java.util.Arrays;

public class SeatGrid {

	private String[][] grid;
	private int xSize;
	private int ySize;

	private static final String FLOOR = ".";
	private static final String SEAT = "L";
	private static final String OCCUPIED = "#";

	public SeatGrid(String[][] grid) {
		this.grid = grid;
		xSize = grid[0].length;
		ySize = grid.length;
	}

	/**
	 * Runs a round
	 * @param occRules int rules for occupied 4 or 5 depening on part 1 or part 2. 
 	 * @param skipFloor boolean if floor should be skipped
	 * @return boolean <code>true</code> if the grid has not changed
	 */
	public boolean runRound(int occRules, boolean skipFloor) {
		

		String[][] newGrid = cloneGrid();
	
		for (int i = 0; i < ySize; i++) {
			for (int j = 0; j < xSize; j++) {
				if (grid[i][j].equals(SEAT)) {
					if (checkSeat(i, j, skipFloor)) {
						newGrid[i][j] = OCCUPIED;
					}
				}

				if (grid[i][j].equals(OCCUPIED)) {
					if (checkOccupied(i, j, occRules, skipFloor)) {
						newGrid[i][j] = SEAT;
					}
				}
			}
		}
		
		int prev = this.hashCode();
		this.grid = newGrid;
		return this.hashCode() == prev;
	}

	private String[][] cloneGrid() {
		String[][] newGrid = new String[ySize][xSize];
		for (int i = 0; i < ySize; i++) {		
			newGrid[i] = Arrays.copyOf(grid[i], grid[i].length);
		}
		return newGrid;
	}
	
	private boolean checkOccupied(int y, int x, int amount, boolean skipFloor) {
		return getAmountFromAllDirs(y, x, skipFloor) >= amount;
	}

	private boolean checkSeat(int y, int x, boolean skipFloor) {
		return getAmountFromAllDirs(y, x, skipFloor) == 0;
	}

	private int getAmountFromAllDirs(int y, int x, boolean skipFloor) {
		int count = 0;
		for (EDir eDir : EDir.values()) {
			Coords c = EDir.getCords(x, y, eDir);
			if (c.isValid(xSize, ySize)) {
				count += checkPos(c,OCCUPIED, skipFloor, eDir) ? 1 : 0;
			}
		}
		return count;
	}

	private boolean checkPos(Coords c, String equals, boolean skipFloor, EDir dir) {
		if (c.isValid(xSize, ySize)) {
			if (grid[c.getY()][c.getX()].equals(FLOOR) && skipFloor) {
				return checkPos(EDir.getCords(c.getX(), c.getY(), dir), equals, skipFloor, dir);
			} else {
				return grid[c.getY()][c.getX()].equals(equals);
			}
		}
		return false;
	}

	public int getOcupied() {
		int count = 0;
		for (String[] s : grid) {
			for (String c : s) {
				if (c.equals(OCCUPIED)) {
					count++;
				}
			}
		}
		return count;
	}

	@Override
	public String toString() {
		String str = "";
		for (String[] s : grid) {
			str += Arrays.toString(s) + "\n";
		}
		return str;
	}

	@Override
	public int hashCode() {
		return super.hashCode() + Arrays.deepHashCode(grid);
	}

}


