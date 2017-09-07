package com.epam.bigdata.restaurant.entity;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import com.epam.bigdata.restaurant.database.DataBaseProcessing;
import com.epam.bigdata.restaurant.logger.InfoLogger;

public class Administrator{
	
	private Order order;
	
	public void sendOrderToExecution(Order order, String clientName) {
		this.order = order;
		DataBaseProcessing.addOrderToDataBase(order, clientName);
		new InfoLogger("New order! Client name: " + clientName);
	}
	
	public Bill fillInBill(String clientName) {
		Bill bill = new Bill();
		BigDecimal totalPrice = BigDecimal.ZERO;
		List<Pair<String, BigDecimal>> dishesInOrder = DataBaseProcessing.getDishesFromOrder(order);
		
		for(int i = 0; i < dishesInOrder.size(); i++) {
			bill.setBillText(String.format("%-4s %-30s %-10s\n", i+1 + ". ", dishesInOrder.get(i).getLeft(), 
					"Price: " + dishesInOrder.get(i).getRight()+"€"));
			totalPrice = totalPrice.add(dishesInOrder.get(i).getRight());
		}
		bill.setBillText("---Total price: " + totalPrice + "€\n");
		bill.setTotalPrice(totalPrice);
		return bill;
	}
}
