/*
 * UserService
 */
package ar.com.infocompany.services;

import java.util.List;

import ar.com.infocompany.infraestructure.BrokenRule;
import ar.com.infocompany.infraestructure.custom_exceptions.ApplicationException;
import ar.com.infocompany.infraestructure.query.Criteria;
import ar.com.infocompany.infraestructure.query.CriteriaOperator;
import ar.com.infocompany.infraestructure.query.Query;
import ar.com.infocompany.model.Company;
import ar.com.infocompany.model.ICompanyRepository;
import ar.com.infocompany.repository.hibernate.CompanyRepository;

public class CompanyService {

	public void registerCompany(Company company) throws ApplicationException {
		List<BrokenRule> brokenRules = company.getBrokenRules();
		if (brokenRules.size() > 0) {
			throw new ApplicationException("", brokenRules);
		}
		ICompanyRepository companyRep = new CompanyRepository();
		Query  query = new Query();
		query.addCriteria(new Criteria(Company.NAME, 
				company.getName(), CriteriaOperator.Equals));
		List<Company> companies = companyRep.findBy(query);
		if (companies.size() > 0) {
			throw new ApplicationException("compania registrada");
		} else {
			companyRep.save(company);
		}
	}
	
}

// eof
