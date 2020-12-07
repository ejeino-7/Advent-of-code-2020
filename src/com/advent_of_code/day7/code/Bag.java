package com.advent_of_code.day7.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bag {

	private static Map<String, Bag> bags = new HashMap<String, Bag>();

	private List<BagRelation> contains;
	private String name;

	public static Bag getBagByName(String name) {
		if (!bags.containsKey(name)) {
			Bag b = new Bag(name);
			bags.put(name, b);
			return b;
		} else {
			return bags.get(name);
		}
	}

	public static Map<String, Bag> getBagMap() {
		return bags;
	}

	private Bag(String name) {
		this.name = name;
		contains = new ArrayList<BagRelation>();
	}

	public void addContainedBag(Bag b, int amount) {
		contains.add(new BagRelation(amount, b));
	}

	
	public boolean doBagContain(String name) {
		boolean cc = false;
		for(BagRelation br : contains) {
			if(br.getBag().name.equals(name)) {
				cc = true;
			} else {
				cc |= br.getBag().doBagContain(name);
			}
			if(cc) {
				return true;
			}
		}
		
		return false;
	}

	public int getAmountOfBagsContained() {
		int i = 0;
		
		for(BagRelation br: contains) {
			i += br.getAmount();
			i += br.getAmount() * br.getBag().getAmountOfBagsContained();
		}
		
		return i;
	}


	private class BagRelation {
		private int amount;
		private Bag bag;
		
		public BagRelation(int amount, Bag bag) {
			this.amount = amount;
			this.bag = bag;
		}

		public int getAmount() {
			return amount;
		}

		public Bag getBag() {
			return bag;
		}
	}
	
}
