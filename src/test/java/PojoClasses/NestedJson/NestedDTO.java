package PojoClasses.NestedJson;

import java.io.Serializable;

public class NestedDTO implements Serializable {
	private String username;
	private String password;
	private ProfileDTO profile;

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setProfile(ProfileDTO profile){
		this.profile = profile;
	}

	public ProfileDTO getProfile(){
		return profile;
	}

	@Override
 	public String toString(){
		return 
			"NestedDTO{" + 
			"username = '" + username + '\'' + 
			",password = '" + password + '\'' + 
			",profile = '" + profile + '\'' + 
			"}";
		}
}