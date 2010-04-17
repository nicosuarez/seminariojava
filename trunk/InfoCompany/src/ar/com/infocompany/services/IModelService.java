package ar.com.infocompany.services;

import java.util.List;

import ar.com.infocompany.entities.Company;


public interface IModelService {
	
	public List<Company> getAllCompanies();
	public Company getCompany(Integer id);
	public void updateCompany(Company company);
	public void insertCompany(Company company);
	public void deleteCompany(Integer id);
}
