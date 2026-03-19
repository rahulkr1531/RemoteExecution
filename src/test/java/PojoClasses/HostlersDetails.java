package PojoClasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class HostlersDetails implements Serializable {
	private String id;
	@JsonProperty("Age")
	private int age;
	@JsonProperty("Name")
	private String name;
	private Address address;

	@Override
 	public String toString(){
		return 
			"HostlersDetails{" + 
			"id = '" + id + '\'' + 
			",age = '" + age + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}