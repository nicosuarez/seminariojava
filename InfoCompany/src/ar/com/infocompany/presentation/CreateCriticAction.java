package ar.com.infocompany.presentation;

import ar.com.infocompany.infraestructure.exceptions.ApplicationException;
import ar.com.infocompany.model.Company;
import ar.com.infocompany.model.Critic;
import ar.com.infocompany.model.ICompanyService;
import ar.com.infocompany.model.IUserService;
import ar.com.infocompany.services.CompanyService;
import ar.com.infocompany.services.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class CreateCriticAction extends ActionSupport {
	ICompanyService companyService = new CompanyService();
	IUserService userService = new UserService();
	
	Critic critic;
	int companyId;
	
	
	public String execute() {
		
		Company company;
		try {
			
			company = companyService.findById(companyId);
			//Critic critic = new Critic(,) 
			company.addCritic(critic);
			companyService.registerCompany(company);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public Critic getCritic() {
		return critic;
	}

	public void setCritic(Critic critic) {
		this.critic = critic;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

}
