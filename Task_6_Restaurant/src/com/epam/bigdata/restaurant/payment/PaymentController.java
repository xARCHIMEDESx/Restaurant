package com.epam.bigdata.restaurant.payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentController {
	
	private List<IPayment> paymentOptions = new ArrayList<>();
	
	public PaymentController() {
		paymentOptions.add(new CreditCardPaymentStrategy());
		paymentOptions.add(new CashPaymentStrategy());
	}
	
	public List<IPayment> getPaymentOptions(){
		return paymentOptions;
	}

}
