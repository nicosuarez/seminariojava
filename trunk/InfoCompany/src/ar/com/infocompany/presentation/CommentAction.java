package ar.com.infocompany.presentation;

import ar.com.infocompany.model.Company;
import ar.com.infocompany.model.Critic;
import ar.com.infocompany.model.User;
import ar.com.infocompany.infraestructure.custom_exceptions.ApplicationException;
import ar.com.infocompany.model.ICompanyService;
import ar.com.infocompany.services.CompanyService;
import ar.com.infocompany.services.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class CommentAction extends ActionSupport{
	ICompanyService compService = new CompanyService();
	UserService userService = new UserService();
	
	int companyId;
	int criticId;
	String textComment;
	Company company;

	public String execute() {
		try {
			//TODO: El usuario debe estar logueado
			User user = userService.findAllUsers().get(0);

			company = compService.findById(companyId);
			Critic critic = company.getCriticById(criticId);
			critic.addReply(user.comment(textComment));
			compService.save(company);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public void setTextComment(String textComment) {
		this.textComment = textComment;
	}
	
	public String getTextComment() {
		return this.textComment;
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
}
