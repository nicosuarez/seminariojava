package ar.com.infocompany.presentation;

import java.util.ArrayList;
import java.util.List;

import ar.com.infocompany.infraestructure.exceptions.ApplicationException;
import ar.com.infocompany.model.Comment;
import ar.com.infocompany.model.Company;
import ar.com.infocompany.model.Critic;
import ar.com.infocompany.model.CriticItem;
import ar.com.infocompany.model.ICompanyService;
import ar.com.infocompany.model.IUserService;
import ar.com.infocompany.model.IViewService;
import ar.com.infocompany.model.Industry;
import ar.com.infocompany.model.Item;
import ar.com.infocompany.model.User;
import ar.com.infocompany.services.CompanyService;
import ar.com.infocompany.services.UserService;
import ar.com.infocompany.services.ViewService;

import com.opensymphony.xwork2.ActionSupport;

public class CreateCriticAction extends ActionSupport implements UserAware {
	ICompanyService companyService = new CompanyService();
	IUserService userService = new UserService();
	IViewService viewService = new ViewService();
	
	Critic critic;
	int companyId;
	
	private int salary;
	private String industryName;
	private String jobName;
	private String country;
	private String state;
	private String comment;
	private List<Integer> itemsScore;
	private String industryCompanyName;
	private String companyName;
	private User user;
	
	public String execute() {

		try {
			Company company = null;
			if(companyId == 0) {
				company = new Company(companyName, Industry.getIndustry(industryCompanyName));
			}else {
				company = companyService.findById(companyId);
			}
			
			Critic critic = new Critic(user, 
									new Comment(user, comment),
									jobName,
									industryName, 
									salary,
									setScoreCriticItems(this.itemsScore)); 
			
			company.addCritic(critic);
			companyService.registerCompany(company);
			companyId = company.getId();
			
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public List<CriticItem> setScoreCriticItems(List<Integer> scores) {
		List<Item> items = viewService.findAllItems();
		List<CriticItem> criticsItems = new ArrayList<CriticItem>();
		CriticItem criticIt = null; 
		
		for(int i = 0; i < items.size(); i++) {
			criticIt = new CriticItem(items.get(i).getName(), scores.get(i));
			criticsItems.add(criticIt);
		}
		
		return criticsItems;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setItemsScore(List<Integer> itemsScore) {
		this.itemsScore = itemsScore;
	}

	public List<Integer> getItemsScore() {
		return itemsScore;
	}

	public ICompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(ICompanyService companyService) {
		this.companyService = companyService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IViewService getViewService() {
		return viewService;
	}

	public void setViewService(IViewService viewService) {
		this.viewService = viewService;
	}

	public String getIndustryCompanyName() {
		return industryCompanyName;
	}

	public void setIndustryCompanyName(String industryCompanyName) {
		this.industryCompanyName = industryCompanyName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}

}
