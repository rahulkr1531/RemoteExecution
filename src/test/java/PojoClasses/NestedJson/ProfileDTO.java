package PojoClasses.NestedJson;

import java.io.Serializable;

public class ProfileDTO implements Serializable {
	private String email;
	private AddressDTO address;

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setAddress(AddressDTO address){
		this.address = address;
	}

	public AddressDTO getAddress(){
		return address;
	}

	@Override
 	public String toString(){
		return 
			"ProfileDTO{" + 
			"email = '" + email + '\'' + 
			",address = '" + address + '\'' + 
			"}";
		}
}