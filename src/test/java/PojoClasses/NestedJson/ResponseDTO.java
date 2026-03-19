package PojoClasses.NestedJson;

import java.io.Serializable;

public class ResponseDTO implements Serializable {
	private String id;
	private int age;
	private String name;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setAge(int age){
		this.age = age;
	}

	public int getAge(){
		return age;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDTO{" + 
			"id = '" + id + '\'' + 
			",age = '" + age + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}