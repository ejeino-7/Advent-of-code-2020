package com.advent_of_code.day11.code;

public class Coords {
	private int x;
	private int y;

	public Coords(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	/**
	 * 
	 * @param maxX int exclusive
	 * @param maxY int exclusive
	 * @return <code>true</code> if in range between 0 and max
	 */
	public boolean isValid(int maxX, int maxY) {	
		return isValid(0, maxX, 0, maxY);
	}
	
	/**
	 * 
	 * @param minX inclusive
	 * @param maxX exclusive
	 * @param minY inclusive
	 * @param maxY exclusive
	 * @return <code>true</code> if in range
	 */
	public boolean isValid(int minX, int maxX, int minY, int maxY) {
		return !((y <  minY ||y >= maxY) || (x < minX || x >= maxX));
	}
}