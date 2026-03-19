package PojoClasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class StudentDetails implements Serializable {
	private String id;
	@JsonProperty("Age")
	private int age;
	@JsonProperty("Name")
	private String name;

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"id = '" + id + '\'' + 
			",age = '" + age + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}