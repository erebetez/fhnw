package domain;

public class Adress {
   public String street;
   public int streetNumber;
   public String zipCode;
   public String city;
   
@Override
public String toString() {
	return street + " " + streetNumber + "\n"
		 + zipCode + " " + city;
}
   
}
