package ar.com.infocompany.service;

import java.util.List;

import ar.com.infocompany.dao.CompanyDao;
import ar.com.infocompany.dao.CompanyHibernateDao;
import ar.com.infocompany.entities.Company;


public class CompanyDaoService implements CompanyService{
	
	private CompanyDao dao;
	
	public CompanyDaoService() {
		this.dao = new CompanyHibernateDao();
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
