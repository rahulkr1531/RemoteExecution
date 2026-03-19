package PojoClasses.ComplexNested;

import java.io.Serializable;
import java.util.List;

public class DepartmentsDTO implements Serializable {
	private String name;
	private HeadDTO head;
	private List<TeamsDTO> teams;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setHead(HeadDTO head){
		this.head = head;
	}

	public HeadDTO getHead(){
		return head;
	}

	public void setTeams(List<TeamsDTO> teams){
		this.teams = teams;
	}

	public List<TeamsDTO> getTeams(){
		return teams;
	}

	@Override
 	public String toString(){
		return 
			"DepartmentsDTO{" + 
			"name = '" + name + '\'' + 
			",head = '" + head + '\'' + 
			",teams = '" + teams + '\'' + 
			"}";
		}
}