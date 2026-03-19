package PojoClasses.NestedJson;

import java.io.Serializable;

public class AddressDTO implements Serializable {
	private String city;
	private String pin;

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setPin(String pin){
		this.pin = pin;
	}

	public String getPin(){
		return pin;
	}

	@Override
 	public String toString(){
		return 
			"AddressDTO{" + 
			"city = '" + city + '\'' + 
			",pin = '" + pin + '\'' + 
			"}";
		}
}