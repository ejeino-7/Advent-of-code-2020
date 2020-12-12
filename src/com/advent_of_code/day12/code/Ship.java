package com.advent_of_code.day12.code;

public class Ship {

	private EShipDir sd;
	private int x;
	private int y;

	public Ship() {
		x = 0;
		y = 0;
		sd = EShipDir.E;
	}

	public void runInst(String s) {
		String d = s.charAt(0) + "";
		int am = Integer.parseInt(s.subSequence(1, s.length()) + "");

		switch (EShipInstDir.getByC(d)) {
		case E:
			x += am;
			break;
		case W:
			x -= am;
			break;
		case N:
			y += am;
			break;
		case S:
			y -= am;
			break;
		case L:
			sd = EShipDir.rotate(am, sd, d);
			break;
		case R:
			sd = EShipDir.rotate(am, sd, d);
			break;
		case F:
			moveForward(am);
			break;

		default:
			System.err.println("ERR");
			break;
		}

	}

	private void moveForward(int am) {
		switch (sd) {
		case E:
			x += am;
			break;
		case W:
			x -= am;
			break;
		case N:
			y += am;
			break;
		case S:
			y -= am;
			break;
		}
	}
	
	public int getManhattanDistance() {
		return Math.abs(x) + Math.abs(y);
	}
}
