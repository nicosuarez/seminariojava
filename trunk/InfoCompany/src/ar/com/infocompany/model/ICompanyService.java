package ar.com.infocompany.model;

import java.util.List;

import ar.com.infocompany.infraestructure.exceptions.ApplicationException;

public interface ICompanyService {
	
	public void registerCompany(Company company) throws ApplicationException;
	public Company findById(int companyId) throws ApplicationException;
	public List<Company> findAll() throws ApplicationException;
	public Company findByName(String name) throws ApplicationException;
	public List<Company> searchByName(String name) throws ApplicationException;
	public void save(Company company);
}
