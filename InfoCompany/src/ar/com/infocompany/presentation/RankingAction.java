package ar.com.infocompany.presentation;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import ar.com.infocompany.infraestructure.exceptions.ApplicationException;
import ar.com.infocompany.model.Company;
import ar.com.infocompany.model.ICompanyService;
import ar.com.infocompany.services.CompanyService;

public class RankingAction extends ActionSupport{
	
	List<Company> companies;
	ICompanyService compService;
	int amount = 10;
	String criteria;
	
	public RankingAction() {
		compService = new CompanyService();
	}
	
	public String execute() {

		if( amount<= 0 || criteria == null)
			return INPUT;
		
		companies = compService.getBestRankedCompanies(amount, criteria);
		return SUCCESS;
	}
	
	public String getCriteria() {
		return criteria;
	}
	
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	
	public List<Company> getCompanies() {
		return companies;
	}
}
