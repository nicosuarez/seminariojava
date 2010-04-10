package com.ar.infocompany.entities;

import java.io.Serializable;
import java.util.List;
import com.ar.infocompany.service.CompanyDaoService;
import com.ar.infocompany.service.CompanyService;


public class Company implements Serializable {
	
	private static final long serialVersionUID = 8660772594337520815L;
	private Integer companyId;
	private String name = null;
	private Integer fieldId;
	private Company company;
	private List<Company> companies;
	private CompanyService companyService = new CompanyDaoService();
	

	public Company() {}
	
	public String getAllCompanies() {
		companies = companyService.getAllCompanies();
		return "success";
	}
	public String insertOrUpdateEst(){
			if (company.getCompanyId() == null) {
				companyService.insertCompany(company);
			}else {
				companyService.updateCompany(company);
			}
		return "success";
	}
	public String deleteCompany(){
		companyService.deleteCompany(company.getCompanyId());
		return "success";
	}
	
	public String setUpForInsertOrUpdateCompany(){
		if (company != null && company.getCompanyId() != null) {
			company = companyService.getCompany(company.getCompanyId());
		}
		return "success";
	}
	

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
	public Integer getFieldId() {
		return fieldId;
	}
	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public List<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	public CompanyService getCompanyService() {
		return companyService;
	}
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}


}
