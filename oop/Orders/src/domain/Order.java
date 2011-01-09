package domain;

import java.util.*;

public class Order {
	private String date;
	private boolean status;
	
	private Customer customer;
	
	public Order(Customer customer){
		this.customer = customer;
		
		Date now = new Date();
		this.date = now.toString();
		
		this.status = true;
		this.customer.addOrder(this);
	}
	
	public String getDate(){
		return date;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}	

	public boolean isStatus() {
		return status;
	}

	public Customer getCustomer(){
		return customer;
	}
	
	@Override
	public String toString() {
		return "Order [date=" + date + ", status=" + status + ", customer="
				+ customer + "]";
	}	

}
