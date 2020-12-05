package com.advent_of_code.day5.code;

import java.util.ArrayList;
import java.util.List;

import com.advent_of_code.day0.util.input.InputParser;

public class Day5 {

	public static void main(String[] args) {
		List<String> lst = InputParser.toStringList(null, "day5_1");
		System.out.println("Seats : " + lst.size());
		List<FlightSeat> fls = getFlightSeats(lst);
		System.out.println("Highest seat ID : " + getHighestSeatId(fls));
		List<Long> ids = getSeatIds(fls);
		ids.sort(null);
		System.out.println("My seat ID : " + getMissingSeatId(ids));
	}

	public static long getMissingSeatId(List<Long> sortedIds) {
		long id = 0L;
		long next = sortedIds.get(0);
		for (Long l : sortedIds) {
			if (l != next) {
				id = next;
				break;
			}
			next++;
		}
		return id;
	}

	public static List<Long> getSeatIds(List<FlightSeat> fls) {
		List<Long> ids = new ArrayList<Long>();
		for (FlightSeat f : fls) {
			ids.add(f.getSeatId());
		}
		return ids;
	}

	public static long getHighestSeatId(List<FlightSeat> fls) {
		long highest = 0L;
		for (FlightSeat f : fls) {
			highest = f.getSeatId() > highest ? f.getSeatId() : highest;
		}
		return highest;
	}

	public static List<FlightSeat> getFlightSeats(List<String> lst) {
		List<FlightSeat> fls = new ArrayList<FlightSeat>();
		for (String row : lst) {
			fls.add(new FlightSeat(row));
		}

		return fls;
	}

}
