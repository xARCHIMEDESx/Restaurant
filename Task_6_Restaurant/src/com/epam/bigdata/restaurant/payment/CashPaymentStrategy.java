package com.epam.bigdata.restaurant.payment;

import java.math.BigDecimal;

public class CashPaymentStrategy implements IPayment {

	@Override
	public void pay(BigDecimal price) {
		// Payment processing...
		System.out.println("\n---Payed in cash: " + price + "€");
	}

	@Override
	public String getDescription() {
		return ("Cash payment");
	}

}
