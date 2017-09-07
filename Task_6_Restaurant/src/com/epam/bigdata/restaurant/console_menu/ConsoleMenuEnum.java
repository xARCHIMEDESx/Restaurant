package com.epam.bigdata.restaurant.console_menu;

public enum ConsoleMenuEnum {	
	SHOW_RESTAURANT_MENU(1),
	ORDER_CONFIRMATION(2),
	EXIT(3);

	private int code;
	    
	private ConsoleMenuEnum(int code) {
		this.code= code;
	}
	    
	public static ConsoleMenuEnum get(int code) {
	    for(ConsoleMenuEnum item : ConsoleMenuEnum.values()) {
	    	if(code == item.code) {
	    		return item;
	        }
	    }
	    return null;
	}
	    
	public int getCode() { return this.code; }
}
