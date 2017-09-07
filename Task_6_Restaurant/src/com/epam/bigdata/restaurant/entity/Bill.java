package com.epam.bigdata.restaurant.entity;

import java.math.BigDecimal;

import com.epam.bigdata.restaurant.logger.InfoLogger;
import com.epam.bigdata.restaurant.payment.IPayment;

public class Bill {

	private IPayment payment;	
	private BigDecimal totalPrice;
	private String billText = "\n===================Order bill===================\n";
	
	public void setPaymentStrategy(IPayment payment) {
		this.payment = payment;
	}
	
	public void setBillText(String text) {
		billText += text;			
	}
	
	public String getBillText() {
		return billText;
	}
	
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public void processPayment() {
		payment.pay(totalPrice);
		new InfoLogger("Order has been payed! Total price: " + totalPrice + "€. " + payment.getDescription());
	}
}
