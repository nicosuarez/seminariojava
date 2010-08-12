package ar.com.infocompany.presentation;

import java.util.List;

import ar.com.infocompany.infraestructure.exceptions.ApplicationException;
import ar.com.infocompany.model.Company;
import ar.com.infocompany.model.Country;
import ar.com.infocompany.model.ICompanyService;
import ar.com.infocompany.model.IViewService;
import ar.com.infocompany.model.Industry;
import ar.com.infocompany.model.Item;
import ar.com.infocompany.model.User;
import ar.com.infocompany.services.CompanyService;
import ar.com.infocompany.services.ViewService;

import com.opensymphony.xwork2.ActionSupport;

public class CriticAction extends ActionSupport implements UserAware {

	ICompanyService companyService = new CompanyService();
	IViewService viewService = new ViewService();
	
	int companyId;
	Company company;
	List<Country> countries;
	List<Industry> industries;
	List<Item> items;
	String countryName;
	String stateName;
	User user;
	
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String execute() {
		
		if(companyId != 0) {
			if(user==null) {
				return INPUT;
			}
			try {
				company = companyService.findById(companyId);
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		countries = viewService.findAllCountries();
		items = viewService.findAllItems();
		industries = viewService.findAllIndustries();
		
		return SUCCESS;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Industry> getIndustries() {
		return industries;
	}

	public void setIndustries(List<Industry> industries) {
		this.industries = industries;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
		
	}
	
}
