package ar.com.infocompany.services;


import java.util.List;

import ar.com.infocompany.dao.ICompanyDAO;
import ar.com.infocompany.entities.Company;


public class ModelService implements IModelService{
	
	private ICompanyDAO companyDAO;
	
	public ModelService() {

	}
	
	public ICompanyDAO getCompanyDAO() {
		return companyDAO;
	}

	public void setCompanyDAO(ICompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}

	public List<Company> getAllCompanies() {
		return companyDAO.getAllCompanies();
	}
	public void deleteCompany(Integer id) {
		companyDAO.deleteCompany(id);
	}
	public Company getCompany(Integer id) {
		return companyDAO.getCompany(id);
	}
	public void insertCompany(Company company) {
		companyDAO.insertCompany(company);
	}
	public void updateCompany(Company company) {
		companyDAO.updateCompany(company);
	}
}
