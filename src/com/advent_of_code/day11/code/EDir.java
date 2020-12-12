package com.advent_of_code.day11.code;

public enum EDir {
	U, D, L, R, UL, UR, DL, DR;

	/**
	 * Get new {@link Coords} object with cordinates in the direction
	 * @param x
	 * @param y
	 * @param dir
	 * @return
	 */
	public static Coords getCords(int x, int y, EDir dir) {
		switch (dir) {
		case U:
			y -= 1;
			break;
		case D:
			y += 1;
			break;
		case L:
			x -= 1;
			break;
		case R:
			x += 1;
			break;
		case UL:
			y -= 1;
			x -= 1;
			break;
		case UR:
			y -= 1;
			x += 1;
			break;
		case DL:
			y += 1;
			x -= 1;
			break;
		case DR:
			y += 1;
			x += 1;
			break;
		default:
			break;
		}
		return new Coords(x, y);
	}
}
