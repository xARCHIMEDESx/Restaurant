package com.epam.bigdata.restaurant.database;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import com.epam.bigdata.restaurant.entity.Order;
import com.epam.bigdata.restaurant.logger.FatalLogger;

public class DataBaseProcessing {
	
	public static List<String> getListOfSubMenues() {
		List<String> submenues = new ArrayList<>();
		try {
			Connection connection = ConnectToDataBase.createConnectionWithDataBase();
			Statement statement = connection.createStatement();
			String sql = "SHOW TABLES";
			ResultSet resultSet = statement.executeQuery(sql);

			while(resultSet.next()){
				String table  = resultSet.getString("tables_in_restaurant");
				if (!table.equals("orders")){
					submenues.add(table);
				}
			} 
			
			resultSet.close();
			statement.close();
			connection.close();
		} 
		
		catch(SQLException se){
			new FatalLogger(se.getMessage());
			System.err.println("\nTechnical issues. Accept our apologies :(");
			System.exit(0);
		}
		return submenues;	
	}
	
	public static String getDishesFromSubmenu(String submenu) {	
		String submenuContent = "";
		try {
			Connection connection = ConnectToDataBase.createConnectionWithDataBase();
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM " + submenu;
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){			  
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String desc = resultSet.getString("description");
				BigDecimal price = resultSet.getBigDecimal("price");
				
				submenuContent += String.format("%-5s %-35s %-40s %-10s\n", "| "+id+".", "| "+name, "| "+desc, "| "+price+"€ |");
			} 
						
			resultSet.close();
			statement.close();
			connection.close();
		} 
		
		catch(SQLException se){
			new FatalLogger(se.getMessage());
			System.err.println("\nTechnical issues. Accept our apologies :(");
			System.exit(0);
		}
		
		return submenuContent;
	}
	
	public static int getSubmenuSize(String submenu) {
		int sizeOfTable = 0;
		try {
			Connection connection = ConnectToDataBase.createConnectionWithDataBase();
			Statement statement = connection.createStatement();			
			ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM " + submenu);
			resultSet.next();
			sizeOfTable = resultSet.getInt(1);
			
			resultSet.close();
			statement.close();
			connection.close();
		} 
		
		catch(SQLException se){
			new FatalLogger(se.getMessage());
			System.err.println("\nTechnical issues. Accept our apologies :(");
			System.exit(0);
		}
		
		return sizeOfTable;
	}
	
	public static List<Pair<String, BigDecimal>> getDishesFromOrder(Order order) {
		List<Pair<String, BigDecimal>> dishesInOrder = new ArrayList<>();
		ResultSet resultSet = null;
		try {
			Connection connection = ConnectToDataBase.createConnectionWithDataBase();
			Statement statement = connection.createStatement();	
			
			for (Pair<String, Integer> dish : order.getOrder()) {
				String sql = "SELECT name, price FROM " + dish.getLeft() + " WHERE id = " + dish.getRight();
				resultSet = statement.executeQuery(sql);
				
				while(resultSet.next()){
					String name = resultSet.getString("name");
					BigDecimal price = resultSet.getBigDecimal("price");
					dishesInOrder.add(new ImmutablePair<String, BigDecimal>(name, price));
				}
			}		
			resultSet.close();
			statement.close();
			connection.close();
		} 
		
		catch(SQLException se){
			new FatalLogger(se.getMessage());
			System.err.println("\nTechnical issues. Accept our apologies :(");
			System.exit(0);
		}
		return dishesInOrder;
	}
	
	public static void addOrderToDataBase(Order order, String clientName) {
		try {
			Connection connection = ConnectToDataBase.createConnectionWithDataBase();
			Statement statement = connection.createStatement();
			connection.setAutoCommit(false);
		
			String sql = "CREATE TABLE IF NOT EXISTS orders ("
					+ "id INT NOT NULL AUTO_INCREMENT, "
					+ "name VARCHAR(255) NOT NULL, "
					+ "price DECIMAL(10,2) NOT NULL, "
					+ "client VARCHAR(255) NOT NULL, "
					+ "timestamp TIMESTAMP NOT NULL, "
					+ "PRIMARY KEY (id))";
			
			statement.addBatch(sql);
			
			for(Pair<String, Integer> dish : order.getOrder()) {
				sql = "INSERT INTO orders (name, price, client) " 
						+ "VALUES ((SELECT name FROM " + dish.getLeft()	+ " WHERE id = " + dish.getRight() +"), "
						+ "(SELECT price FROM " + dish.getLeft() + " WHERE id = " + dish.getRight() +"), '"
						+ clientName + "')";
				statement.addBatch(sql);
			}
			statement.executeBatch();			
			connection.commit();
			
			statement.close();
			connection.close();
		} 
		
		catch(SQLException se){
			new FatalLogger(se.getMessage());
			System.err.println("\nTechnical issues. Accept our apologies :(");
			System.exit(0);
		}
		
	}
	
}
