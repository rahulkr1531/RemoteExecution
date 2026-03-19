package PojoClasses.ComplexNested;

import java.io.Serializable;
import java.util.List;

public class MembersDTO implements Serializable {
	private int id;
	private String name;
	private List<String> skills;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSkills(List<String> skills){
		this.skills = skills;
	}

	public List<String> getSkills(){
		return skills;
	}

	@Override
 	public String toString(){
		return 
			"MembersDTO{" + 
			"id = '" + id + '\'' + 
			",name = '" + name + '\'' + 
			",skills = '" + skills + '\'' + 
			"}";
		}
}