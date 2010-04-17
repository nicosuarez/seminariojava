package ar.com.infocompany.services;

import java.util.List;

import ar.com.infocompany.dao.ICompanyDAO;
import ar.com.infocompany.dao.CompanyHibernateDAO;
import ar.com.infocompany.entities.Company;


public class ModelService implements IModelService{
	
	private ICompanyDAO dao;
	
	public ModelService() {
		this.dao = new CompanyHibernateDAO();
	}
	public List<Company> getAllCompanies() {
		return dao.getAllCompanies();
	}
	public void deleteCompany(Integer id) {
		dao.deleteCompany(id);
	}
	public Company getCompany(Integer id) {
		return dao.getCompany(id);
	}
	public void insertCompany(Company company) {
		dao.insertCompany(company);
	}
	public void updateCompany(Company company) {
		dao.updateCompany(company);
	}
}
