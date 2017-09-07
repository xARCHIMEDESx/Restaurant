package com.epam.bigdata.restaurant.console_menu;

import java.util.InputMismatchException;
import java.util.List;

import com.epam.bigdata.restaurant.database.DataBaseProcessing;
import com.epam.bigdata.restaurant.entity.Client;
import com.epam.bigdata.restaurant.scanner.SingletonScanner;

public class DishesMenu {

	private ChooseDishesMenu cdm;
	
	public DishesMenu(Client client) {
		this.cdm = new ChooseDishesMenu(client);
	}

	public void execute() {
		List<String> submenues = DataBaseProcessing.getListOfSubMenues();		
		while(true){
			System.out.println("\n------MENU------");
			for (int i = 1; i <= submenues.size(); i++)
			{
			    System.out.println("Press " + i + " to choose: " + submenues.get(i-1).toUpperCase());
			}				
			System.out.println("\nPress 0 to return.\n");	
			
			try {					
				System.out.print("Please, make your choice: ");
				int id = SingletonScanner.getInstance().nextInt();					
		
				if (id == 0) {
					break;
				}
					
				cdm.execute(submenues.get(id-1));				
			}
				
			catch(InputMismatchException | IndexOutOfBoundsException ex){
				System.err.println("\nWrong input. Try again.");		
				SingletonScanner.getInstance().next();
				execute();
				break;
			}
		}	
	}
}
