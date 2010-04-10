package com.ar.infocompany.persistence;

import java.util.List;

import com.ar.infocompany.entities.Company;

public interface CompanyDao {
	
	public List<Company> getAllCompanies();
	public Company getCompany(Integer id);
	public void updateCompany(Company company);
	public void insertCompany(Company company);
	public void deleteCompany(Integer id);

}
