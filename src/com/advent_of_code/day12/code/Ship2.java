package com.advent_of_code.day12.code;

public class Ship2 {
	private int x;
	private int y;
	private int wx;
	private int wy;

	public Ship2() {
		x = 0;
		y = 0;
		wx = 10;
		wy = 1;
	}

	public void runInst(String s) {
		String d = s.charAt(0) + "";
		int am = Integer.parseInt(s.subSequence(1, s.length()) + "");

		switch (EShipInstDir.getByC(d)) {
		case E:
			wx += am;
			break;
		case W:
			wx -= am;
			break;
		case N:
			wy += am;
			break;
		case S:
			wy -= am;
			break;
		case L:
			rotateWP(-am);
			break;
		case R:
			rotateWP(am);
			break;
		case F:
			moveForward(am);
			break;

		default:
			System.err.println("ERR");
			break;
		}
	}

	private void rotateWP(int am) {
		double radians = 0.0D;
		am = am % 360;
		if (am == -90 || am == 270) {
			radians = Math.PI / 2;
		}
		if (am == -180 || am == 180) {
			radians = Math.PI;
		}
		if (am == -270 || am == 90) {
			radians = (3.0D / 2.0D) * Math.PI;
		}

		int px = wx;
		int py = wy;

		wx = (int) (px * (int) Math.cos(radians) - py * (int) Math.sin(radians));
		wy = (int) (px * (int) Math.sin(radians) + py * (int) Math.cos(radians));

	}

	private void moveForward(int am) {
		x += am * wx;
		y += am * wy;
	}

	public int getManhattanDistance() {
		return Math.abs(x) + Math.abs(y);
	}

}
