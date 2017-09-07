package com.epam.bigdata.restaurant.console_menu;

import java.util.InputMismatchException;

import com.epam.bigdata.restaurant.database.DataBaseProcessing;
import com.epam.bigdata.restaurant.entity.Client;
import com.epam.bigdata.restaurant.scanner.SingletonScanner;

public class ChooseDishesMenu {
	
	private Client client;
	private int sizeOfTable;
	private String submenu;
	
	public ChooseDishesMenu(Client client) {
		this.client = client;
	}

	public void execute(String submenu) {
		this.submenu = submenu;
		
		System.out.print("\n======================================"+submenu.toUpperCase()+"============================================");
		System.out.print("\n+-----+-----------------------------------+----------------------------------------+-------+\n");
		System.out.printf("%-5s %-35s %-40s %-10s\n", "| No.", "| Name", "| Description", "| Price |");
		System.out.print("+-----+-----------------------------------+----------------------------------------+-------+\n");
		System.out.print(DataBaseProcessing.getDishesFromSubmenu(submenu));
		System.out.print("+-----+-----------------------------------+----------------------------------------+-------+\n");
		
		sizeOfTable = DataBaseProcessing.getSubmenuSize(submenu);
		
		chooseDishes();
	}
	
	private void chooseDishes() {
		while(true){	
			try {				
				System.out.println("\nPress 0 to return.\n");
				System.out.print("Choose the dish № you want to order: ");
				int id = SingletonScanner.getInstance().nextInt();					
		
				if (id > sizeOfTable) {
					throw new InputMismatchException();
				}
				
				if (id == 0) {
					break;
				}
			
				String[] orderData = {submenu, String.valueOf(id)};
				client.addDishToOrder(orderData);						
			}
				
			catch(InputMismatchException ex){
				System.err.println("\nWrong input. Try again.");		
				SingletonScanner.getInstance().next();
				chooseDishes();
				break;
			}
		}	
	}	
}
