package PojoClasses.ComplexNested;

import java.io.Serializable;
import java.util.List;

public class TeamsDTO implements Serializable {
	private String teamName;
	private List<MembersDTO> members;

	public void setTeamName(String teamName){
		this.teamName = teamName;
	}

	public String getTeamName(){
		return teamName;
	}

	public void setMembers(List<MembersDTO> members){
		this.members = members;
	}

	public List<MembersDTO> getMembers(){
		return members;
	}

	@Override
 	public String toString(){
		return 
			"TeamsDTO{" + 
			"teamName = '" + teamName + '\'' + 
			",members = '" + members + '\'' + 
			"}";
		}
}