package ar.com.infocompany.presentation;

import ar.com.infocompany.model.Company;
import ar.com.infocompany.model.Critic;
import ar.com.infocompany.infraestructure.custom_exceptions.ApplicationException;
import ar.com.infocompany.model.ICompanyService;
import ar.com.infocompany.services.CompanyService;


import com.opensymphony.xwork2.ActionSupport;

public class CriticLikeAction extends ActionSupport{
	ICompanyService compService = new CompanyService();
	
	int companyId;
	int criticId;
	int	value;
	
	public String execute() {
		try {

			Company company = compService.findById(companyId);
			Critic critic = company.getCriticById(criticId);
			
			if(value == 1)
				critic.increaseCriticScore();
			else if( value == -1)
				critic.decreaseCriticScore();
			
			compService.save(company);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	public int getCompanyId() {
		return this.companyId;
	}
	
	public void setCriticId(int criticId) {
		this.criticId = criticId;
	}
	
	public int getCriticId() {
		return this.criticId;
	}
	
	public int getVale() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
}
