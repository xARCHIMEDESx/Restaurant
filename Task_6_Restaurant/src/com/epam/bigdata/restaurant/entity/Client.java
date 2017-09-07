package com.epam.bigdata.restaurant.entity;

import com.epam.bigdata.restaurant.console_menu.PaymentOptionsMenu;

public class Client {
	private Order order;	

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Order confirmOrder() {
		return order;
	}
	
	public void addDishToOrder(String[] orderData) {
		String submenu = orderData[0];
		int dishID = Integer.valueOf(orderData[1]);
		
		order.addDishToOrder(submenu, dishID);		
	}
	
	public void payTheBill(Bill bill) {
		System.out.println(bill.getBillText());
		choosePaymentOptions(bill);
		bill.processPayment();
	}
		
	private void choosePaymentOptions(Bill bill) {
		new PaymentOptionsMenu(bill).showPayment();
	}
}
