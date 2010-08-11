package ar.com.infocompany.presentation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import ar.com.infocompany.infraestructure.custom_exceptions.InvalidLocationException;
import ar.com.infocompany.model.Comment;
import ar.com.infocompany.model.Company;
import ar.com.infocompany.model.Critic;
import ar.com.infocompany.model.ICompanyRepository;
import ar.com.infocompany.model.Industry;
import ar.com.infocompany.model.Job;
import ar.com.infocompany.model.User;
import ar.com.infocompany.repository.hibernate.CompanyRepository;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CompanyAction extends ActionSupport {
	ICompanyRepository companyRepository = new CompanyRepository();
	
	int companyId;
	Company company;
	int repliesSize;
	String postedDate;
	String jobName;
	String industryName;

	public String execute() {

		//Company compSession = (Company)ActionContext.getContext().getSession().get("Company");
		
		User user = null;	
		user = new User("scamjayi","password","scamjayi@hotmail.com","induUser","jobNameUser",
			"Argentina","Bs As",1980);
		user.increaseReputation();
		user.increaseReputation();
		user.increaseReputation();

		Comment comment = new Comment(user, "Mensaje de comentario");
		Comment comment1 = new Comment(user, "Mensaje de comentario de un ususario");
		
		Critic critic = new Critic(user,comment,"Job","industry",2000);
		critic.addReply(comment1);
		critic.addReply(comment1);
		company = new Company("Sistran", Industry.getIndustry("Industry"));
		company.addCritic(critic);
		company.addCritic(critic);
		
		repliesSize = critic.getRepliesSize();
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
		postedDate = formatoDeFecha.format(critic.getAuthorComment().getDate());
		industryName = critic.getIndustry().getName();
		jobName = critic.getJob().getName();
		
		//company = companyRepository.findBy(companyId);
		return SUCCESS;
	}

	public int getRepliesSize() {
		return repliesSize;
	}

	public void setRepliesSize(int repliesSize) {
		this.repliesSize = repliesSize;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
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
	
	public String getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
}
