package domain;

public class StartAppl {
	public static void main(String[] args) {
		Adress adress = new Adress();
		adress.street = "Redlichstrasse";
		adress.streetNumber = 22;
		adress.zipCode = "4711";
		adress.city = "Parfümstadt";

		Customer myCustomer = new Customer();
		myCustomer.setName("Fridolin Bünzli");
		myCustomer.setAdress(adress);
		
		Order order1 = new Order(myCustomer);
		Order order2 = new Order(myCustomer);
		
		order1.setStatus(true);
		order2.setStatus(false);
		
		System.out.println(myCustomer);
		

	}

}
