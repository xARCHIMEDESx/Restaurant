package com.epam.bigdata.restaurant.console_menu;

import com.epam.bigdata.restaurant.entity.*;
import com.epam.bigdata.restaurant.scanner.SingletonScanner;

public class ConfirmOrderMenu {
	
	private Administrator administrator;
	private Client client;
	
	public ConfirmOrderMenu(Client client, Administrator administrator) {
		this.administrator = administrator;
		this.client = client;
	}
	
	private String getClientName() {				
		System.out.print("\n---Enter your name for we could authenticate you: ");		
		return SingletonScanner.getInstance().next();	
	}
	
	public void execute() {
		try {
			String clientName = getClientName();
			administrator.sendOrderToExecution(client.confirmOrder(), clientName);	
			System.out.println("\nOrder has been confirmed and sent to the kitchen.");
			client.payTheBill(administrator.fillInBill(clientName));
			System.out.println("\nThank you. Have a nice meal!");
			System.exit(0);
		}
		
		catch(NullPointerException e) {
			System.err.println(e.getMessage());
		}
	}
}
