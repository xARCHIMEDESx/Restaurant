package com.epam.bigdata.restaurant.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class Order{

	private List<Pair<String, Integer>> orderedList = new ArrayList<>();
	
	public void addDishToOrder(String submenu, int dishID) {
		orderedList.add(new ImmutablePair<String, Integer>(submenu, dishID));
		System.out.println("Added!");
	}	
	
	public List<Pair<String, Integer>> getOrder() throws NullPointerException{
		if (orderedList.isEmpty()) {
			throw new NullPointerException("\nYour order is empty! Choose something first.");
		}
		return orderedList;
	}
}
