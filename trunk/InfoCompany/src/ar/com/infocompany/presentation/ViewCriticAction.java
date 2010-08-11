package ar.com.infocompany.presentation;

import java.text.SimpleDateFormat;

import ar.com.infocompany.model.Comment;
import ar.com.infocompany.model.Company;
import ar.com.infocompany.model.Critic;
import ar.com.infocompany.model.ICompanyRepository;
import ar.com.infocompany.model.ICriticRepository;
import ar.com.infocompany.model.Industry;
import ar.com.infocompany.model.User;
import ar.com.infocompany.repository.hibernate.CompanyRepository;
import ar.com.infocompany.repository.hibernate.CriticRepository;

import com.opensymphony.xwork2.ActionSupport;

public class ViewCriticAction extends ActionSupport {
	
	ICriticRepository criticRepository = new CriticRepository();
	ICompanyRepository companyRepository = new CompanyRepository();
	
	Critic critic;
	Company company;
	int criticId;
	int companyId;

	public String execute() {
		
		User user = null;	
		user = new User("scamjayi","password","scamjayi@hotmail.com","induUser","jobNameUser",
			"Argentina","Bs As",1980);
		user.increaseReputation();
		user.increaseReputation();
		user.increaseReputation();

		Comment comment = new Comment(user, "Mensaje de comentario");
		Comment comment1 = new Comment(user, "Mensaje de comentario de un ususario");
		
		critic = new Critic(user,comment,"Job","industry",2000);
		critic.addReply(comment1);
		critic.addReply(comment1);
		
//		
//		repliesSize = critic.getRepliesSize();
//		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
//		postedDate = formatoDeFecha.format(critic.getAuthorComment().getDate());
//		industryName = critic.getIndustry().getName();
//		jobName = critic.getJob().getName();
		
		
//		company = companyRepository.findBy(companyId);
//		critic = company.getCriticById(critic.getId());
		
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
