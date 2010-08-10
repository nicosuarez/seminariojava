package ar.com.infocompany.presentation;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;

import ar.com.infocompany.model.Company;
import ar.com.infocompany.model.ICompanyService;
import ar.com.infocompany.model.Industry;
import ar.com.infocompany.services.CompanyService;

import com.opensymphony.xwork2.ActionSupport;

public class SearchCompanyAction extends ActionSupport {
	
	List<Company> companies;
	String companyName;
	ICompanyService companyService = new CompanyService();
	
    public String execute() throws Exception {
    	
    	companies = new ArrayList<Company>();
    	Company comp = new Company("Sistran", Industry.getIndustry("hola"));
    	companies.add(comp);
    	companies.add(comp);
        //companies = this.companyService.searchByName(companyName);
        return SUCCESS;
    }

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
