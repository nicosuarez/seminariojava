package ar.com.infocompany.actions;

import java.util.List;

import ar.com.infocompany.entities.Company;
import ar.com.infocompany.services.IModelService;

import com.opensymphony.xwork2.ActionSupport;

public class CompanyAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private Company company = new Company();
	private List<Company> companies;
	private IModelService modelService;
	
	
	public IModelService getModelService() {
		return modelService;
	}
	
	public void setModelService(IModelService modelService) {
		this.modelService = modelService;
	}
	
	public String getAllCompanies() {
		companies = modelService.getAllCompanies();
		return "success";
	}
	
	public String insertOrUpdateCompany(){
			if (company.getCompanyId() == null) {
				modelService.insertCompany(company);
			}else {
				modelService.updateCompany(company);
			}
		return "success";
	}
	
	public String deleteCompany(){
		modelService.deleteCompany(company.getCompanyId());
		return "success";
	}
	
	public String setUpForInsertOrUpdateCompany(){
		if (company != null && company.getCompanyId() != null) {
			company = modelService.getCompany(company.getCompanyId());
		}
		return "success";
	}
	
	public List<Company> getCompanies() {
		return companies;
	}
	
	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
