package com.epam.bigdata.restaurant.payment;

import java.math.BigDecimal;

public class CreditCardPaymentStrategy implements IPayment {

	@Override
	public void pay(BigDecimal price) {
		// Payment processing...
		System.out.println("\n---Payed by credit card: " + price + "€");
	}

	@Override
	public String getDescription() {
		return ("Credit card payment");
	}

}
