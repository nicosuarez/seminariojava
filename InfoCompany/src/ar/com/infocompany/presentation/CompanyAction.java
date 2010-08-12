package ar.com.infocompany.presentation;


import java.util.List;

import ar.com.infocompany.infraestructure.exceptions.ApplicationException;
import ar.com.infocompany.model.Company;

import ar.com.infocompany.model.CriticItem;
import ar.com.infocompany.model.ICompanyService;
import ar.com.infocompany.model.IViewService;
import ar.com.infocompany.services.CompanyService;
import ar.com.infocompany.services.ViewService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CompanyAction extends ActionSupport {
	ICompanyService compService = new CompanyService();
	IViewService viewService = new ViewService();
	
	int companyId;
	Company company;
	List<CriticItem> criticItems;
	
	public String execute() {

		//Company compSession = (Company)ActionContext.getContext().getSession().get("Company");
		try {
			company = compService.findById(companyId);
			criticItems = company.getItems(viewService.getItemsName());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
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
	
	public void setCriticItems(List<CriticItem> criticItems) {
		this.criticItems = criticItems;
	}
	
	public List<CriticItem> getCriticItems() {
		return this.criticItems;
	}
}
