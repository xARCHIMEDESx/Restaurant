package com.epam.bigdata.restaurant.console_menu;

import java.util.InputMismatchException;

import com.epam.bigdata.restaurant.entity.*;
import com.epam.bigdata.restaurant.scanner.SingletonScanner;

public class MainMenu {	
	private Client client;
	private Order order;
	private Administrator administrator;

	public MainMenu(){
		client = new Client();
		administrator = new Administrator();		
		order = new Order();			
		client.setOrder(order);		
	}
	
	public void showMenu(){
		System.out.println("\t\t\t===Welcome to \"El Castillo del Caballero\", our spanish cuisine restaurant===");
		while(true){			
			try{				
				System.out.println("\nPress 1 to Show restaurant menu");
				System.out.println("Press 2 to Confirm your order");
				System.out.println("Press 3 to Exit");

				System.out.print("Make your choice: ");
				
				int userInput = SingletonScanner.getInstance().nextInt();
				runMenu(userInput);					
			}
		
			catch(InputMismatchException | NullPointerException ex){
				System.err.println("\nWrong input. Try again");
				SingletonScanner.getInstance().next();
				showMenu();		
				break;
			}
		}
	}
	
	public void runMenu(int choice) {
        ConsoleMenuEnum consoleMenu = ConsoleMenuEnum.get(choice);
        
        switch(consoleMenu){        
        case SHOW_RESTAURANT_MENU:
        	new DishesMenu(client).execute();
        	break;
        	
        case ORDER_CONFIRMATION:
        	new ConfirmOrderMenu(client, administrator).execute();
        	break;
        	
        case EXIT:
        	System.exit(0);
        	break;
        }
    }

}