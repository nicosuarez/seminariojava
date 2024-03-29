/*
 * UserService
 */
package ar.com.infocompany.services;

import java.util.Collections;
import java.util.List;

import ar.com.infocompany.infraestructure.BrokenRule;
import ar.com.infocompany.infraestructure.exceptions.ApplicationException;
import ar.com.infocompany.infraestructure.query.Criteria;
import ar.com.infocompany.infraestructure.query.CriteriaOperator;
import ar.com.infocompany.infraestructure.query.Query;
import ar.com.infocompany.model.Company;
import ar.com.infocompany.model.ICompanyRepository;
import ar.com.infocompany.model.ICompanyService;
import ar.com.infocompany.repository.hibernate.CompanyRepository;

public class CompanyService implements ICompanyService {

	ICompanyRepository companyRep = new CompanyRepository();
	
	public void registerCompany(Company company) throws ApplicationException {
		List<BrokenRule> brokenRules = company.getBrokenRules();
		if (brokenRules.size() > 0) {
			throw new ApplicationException("", brokenRules);
		}
		
		if (this.companyExist(company)) {
			throw new ApplicationException("compania registrada");
		} else {
			companyRep.save(company);
		}
	}
	
	public boolean companyExist(Company company) throws ApplicationException {
		return (this.findByName(company.getName()) != null);
	}

	@Override
	public List<Company> findAll() throws ApplicationException {
		return companyRep.findAll();
	}

	@Override
	public Company findById(int companyId) throws ApplicationException {
		return companyRep.findBy(companyId);
	}

	@Override
	public Company findByName(String name) throws ApplicationException {
		Company company = null;
		Query  query = new Query();
		query.addCriteria(new Criteria(Company.NAME, 
				name, CriteriaOperator.Like));
		List<Company> companies = companyRep.findBy(query);
		if(companies.size() > 0) {
			company = companies.get(0);
		}
		return company;
	}
	
	@Override
	public List<Company> searchByName(String name)
			throws ApplicationException {
		Query  query = new Query();
		query.addCriteria(new Criteria(Company.NAME, 
				name, CriteriaOperator.Like));
		List<Company> companies = companyRep.findBy(query);
		return companies;
	}

	@Override
	public void save(Company company) {
		companyRep.save(company);
		
	}
	
	public List<Company> getBestRankedCompanies(int n, String orderBy) {
		List<Company> companies = this.companyRep.findAll();
		synchronized(companies) {
			if( orderBy.compareTo("RATING") == 0 )
				Collections.sort(companies, Company.RATING_ORDER);
			else if( orderBy.compareTo("ENVIROMENT") == 0 )
				Collections.sort(companies, Company.ENVIROMENT_ORDER);
			else if( orderBy.compareTo("BENEFITIES") == 0 )
				Collections.sort(companies, Company.BENEFITIES_ORDER);
			else if( orderBy.compareTo("GROWTH") == 0 )
				Collections.sort(companies, Company.GROWTH_ORDER);
			
			if (companies.size() > n) {
				companies = companies.subList(0, n);
			}
		}		
		return companies;
	}
	
}

// eof
