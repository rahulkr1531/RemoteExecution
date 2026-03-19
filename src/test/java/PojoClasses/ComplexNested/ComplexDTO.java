package PojoClasses.ComplexNested;

import java.io.Serializable;
import java.util.List;

public class ComplexDTO implements Serializable {
	private String organization;
	private List<DepartmentsDTO> departments;

	public void setOrganization(String organization){
		this.organization = organization;
	}

	public String getOrganization(){
		return organization;
	}

	public void setDepartments(List<DepartmentsDTO> departments){
		this.departments = departments;
	}

	public List<DepartmentsDTO> getDepartments(){
		return departments;
	}

	@Override
 	public String toString(){
		return 
			"ComplexDTO{" + 
			"organization = '" + organization + '\'' + 
			",departments = '" + departments + '\'' + 
			"}";
		}
}