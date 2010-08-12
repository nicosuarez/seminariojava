package ar.com.infocompany.presentation;

import ar.com.infocompany.infraestructure.exceptions.ApplicationException;
import ar.com.infocompany.model.Comment;
import ar.com.infocompany.model.Company;
import ar.com.infocompany.model.Critic;
import ar.com.infocompany.model.ICompanyService;
import ar.com.infocompany.services.CompanyService;

import com.opensymphony.xwork2.ActionSupport;

public class ViewCriticAction extends ActionSupport {

	ICompanyService companyService;
	Critic critic;
	Company company;
	int criticId;
	int companyId;

	public String execute() {
		companyService = new CompanyService();
		
		try {
			company = companyService.findById(companyId);
			critic = company.getCriticById(criticId);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}		
		return SUCCESS;
	}
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Critic getCritic() {
		return critic;
	}

	public void setCritic(Critic critic) {
		this.critic = critic;
	}

	public int getCriticId() {
		return criticId;
	}

	public void setCriticId(int criticId) {
		this.criticId = criticId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
}
