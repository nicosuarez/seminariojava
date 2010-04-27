package ar.com.infocompany.entities;

import java.io.Serializable;

public class Company implements Serializable {
	
	private static final long serialVersionUID = 8660772594337520815L;
	private Integer companyId;
	private String name = null;
	private Field fieldId;
	private Company company;

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
	public Field getFieldId() {
		return fieldId;
	}
	public void setFieldId(Field fieldId) {
		this.fieldId = fieldId;
	}

	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
}
