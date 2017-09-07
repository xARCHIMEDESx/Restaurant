package com.epam.bigdata.restaurant.console_menu;

import java.util.InputMismatchException;

import com.epam.bigdata.restaurant.entity.Bill;
import com.epam.bigdata.restaurant.payment.IPayment;
import com.epam.bigdata.restaurant.payment.PaymentController;
import com.epam.bigdata.restaurant.scanner.SingletonScanner;

public class PaymentOptionsMenu {
	private Bill bill;
	private PaymentController paymentOptions;

	public PaymentOptionsMenu(Bill bill) {
		this.bill = bill;
		paymentOptions = new PaymentController();
	}

	private void choosePayment(int id) {
		IPayment payment = paymentOptions.getPaymentOptions().get(id-1);
		bill.setPaymentStrategy(payment);
	}
	
	public void showPayment() {
		while(true){	
			try {
				for (int i = 1; i <= paymentOptions.getPaymentOptions().size(); i++){
				    System.out.println("Press " + i + " to choose: " + paymentOptions.getPaymentOptions().get(i-1).getDescription());
				}	
				
				System.out.print("\nMake your choice: ");
				int id = SingletonScanner.getInstance().nextInt();					
					
				choosePayment(id);	
				break;
			}
				
			catch(InputMismatchException | IndexOutOfBoundsException ex){
				System.err.println("\nWrong input. Try again.");		
				SingletonScanner.getInstance().next();
			}
		}		
	}
}
