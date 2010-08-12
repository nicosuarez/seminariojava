package ar.com.infocompany.presentation;

import java.util.HashMap;
import java.util.List;

import org.mcavallo.opencloud.Cloud;
import org.mcavallo.opencloud.Tag;

import ar.com.infocompany.model.Company;
import ar.com.infocompany.model.ICompanyService;
import ar.com.infocompany.services.CompanyService;

import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport {

	private String name;
	private Cloud companyCloud;
	private ICompanyService companyService;
	
	public WelcomeAction() {
		this.companyCloud = new Cloud();;
		this.companyService = new CompanyService();
	}
	
	public String execute() {
	
		updateCloudTags();
		return SUCCESS;
	}
	
	public void validate() {
	
	}
	
	public Cloud updateCloudTags() {
        
        companyCloud.clear();
        List<Company> companies = companyService.getBestRankedCompanies(10, Company.RATING_ORDER.toString());
  
        if(companies != null) {
	        for (Company company : companies) {
	        	companyCloud.addTag(new Tag(company.getName(), "ViewCompanyAction.action?companyId=" + String.valueOf(company.getId()) , company.getRating() ));
	        }
	        companyCloud.setMaxTagsToDisplay(15);
	        companyCloud.setMaxWeight(30);
	        companyCloud.setMinWeight(1);
        }
 
        return companyCloud;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public Cloud getCompanyCloud() {
		return companyCloud;
	}

	public void setCompanyCloud(Cloud companyCloud) {
		this.companyCloud = companyCloud;
	}

	public ICompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(ICompanyService companyService) {
		this.companyService = companyService;
	}
}
