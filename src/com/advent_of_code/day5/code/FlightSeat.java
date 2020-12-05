package com.advent_of_code.day5.code;

public class FlightSeat {

	private int row;
	private int column;
	
	
	public FlightSeat(String row) {
		
		int rowptrL = 0;
		int rowptrH = 127;
		int colptrL = 0;
		int colptrH = 7;
		
		for(char c : row.toCharArray()) {
			if(c == 'F') {
				
				rowptrH -= Math.floorDiv((rowptrH - rowptrL), 2) +1;
				this.row = rowptrH;
			} else if( c == 'B') {
				rowptrL += Math.floorDiv((rowptrH - rowptrL), 2) +1 ;
				this.row = rowptrL;
			} else if ( c== 'L') {
				colptrH -= Math.floorDiv((colptrH - colptrL), 2) +1 ;
				this.column = colptrH;
			} else if ( c == 'R') {
				colptrL += Math.floorDiv((colptrH - colptrL), 2) +1;
				this.column = colptrL;
			}
		}
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FlightSeat [row=");
		builder.append(row);
		builder.append(", column=");
		builder.append(column);
		builder.append("]");
		return builder.toString();
	}



	public long getSeatId() {
		return row * 8L + column;
	}
}
