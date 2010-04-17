package ar.com.infocompany.service;

import java.util.List;

import ar.com.infocompany.entities.Company;


public interface CompanyService {
	
	public List<Company> getAllCompanies();
	public Company getCompany(Integer id);
	public void updateCompany(Company company);
	public void insertCompany(Company company);
	public void deleteCompany(Integer id);
}
