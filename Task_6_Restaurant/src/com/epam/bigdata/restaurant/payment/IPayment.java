package com.epam.bigdata.restaurant.payment;

import java.math.BigDecimal;

public interface IPayment {
	void pay(BigDecimal price);
	String getDescription();
}
