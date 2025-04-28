package com.iterator;

public class MyArray implements MyIterable {
	private static final int MAX_ITEMS = 6;
	private int numberOfItems;
	private String[] menuItems;
  
	public MyArray() {
		numberOfItems = 0;
		menuItems = new String[MAX_ITEMS];
	}
  
	public void addItem(String name) {
		/* TODO */
	}
 
	public String[] getMenuItems() {
		/* TODO */
	}
  
	public Iterator createIterator() {
		/* TODO */
	}
 
	public String toString() {
		return "My Array Structure";
	}
}
