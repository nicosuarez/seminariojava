package ar.com.infocompany.entities;

import java.io.Serializable;

public class Company implements Serializable {
	
	private static final long serialVersionUID = 8660772594337520815L;
	private Integer companyId;
	private String name = null;
	private Field companyField;

	public Company() {}
	
	
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Field getCompanyField() {
		return companyField;
	}
	public void setCompanyField(Field companyField) {
		this.companyField = companyField;
	}

}
