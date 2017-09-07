package com.epam.bigdata.restaurant.scanner;
import java.util.Scanner;

public class SingletonScanner {
	
    private static SingletonScanner instance = null;
    private static Scanner reader;
    private SingletonScanner() {
    	reader = new Scanner(System.in);
    }
    
    public static SingletonScanner getInstance() {
        if (instance == null) {
        	instance = new SingletonScanner();
        }
        return instance;
    }
    
    public int nextInt(){
    	return reader.nextInt();
    }
    
    public String next(){
    	return reader.next();
    }
}
