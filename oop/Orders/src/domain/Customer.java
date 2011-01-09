package domain;

import java.util.*;

public class Customer {
	private String name;
	private Adress adress;
	private Vector<Order> orderList;

	Customer(){
		this.orderList = new Vector<Order>();
	}
	
	public Vector<Order> getOrderList() {
		return orderList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public void addOrder(Order order){
		orderList.add(order);
	}
	
	public void printOrdersDate(){
		for( int i = 0; i < orderList.size(); ++i ){
			System.out.println( orderList.elementAt(i).getDate() );
		}
	}

	@Override
	public String toString() {
		StringBuilder display = new StringBuilder();
		
		display.append("Kunde:\n");
		display.append("======\n");
		
		display.append(name + "\n" + adress + "\n\n");
		
		display.append("Orders:\n");
		display.append("=======\n");
		
		for(int i = 0; i < orderList.size(); ++i){
			display.append(orderList.elementAt(i).getDate() + " ");
			display.append(orderList.elementAt(i).isStatus());
			display.append("\n");			
		}
		return display.toString();
	}
}
