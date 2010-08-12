package ar.com.infocompany.presentation;

import ar.com.infocompany.infraestructure.exceptions.ApplicationException;
import ar.com.infocompany.model.IUserService;
import ar.com.infocompany.model.Industry;
import ar.com.infocompany.model.Job;
import ar.com.infocompany.model.User;
import ar.com.infocompany.services.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class EditUserAction extends ActionSupport implements UserAware {

	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserService();
	private String industryName;
	private String jobName;
	private User user;
	
	public String execute(){
		try {
			if(user != null) {
				user.setIndustry(Industry.getIndustry(industryName));
				user.setJob(Job.getJob(jobName));
				userService.updateUser(user);
			}else {
				return INPUT;
			}
		} catch (ApplicationException e) {
			this.addActionMessage(e.getMessage());
			return INPUT;
		}
		
		return SUCCESS;
	}
	
	public String userRegisterSuccesfull(){
		return SUCCESS;
	}
	
	public IUserService getUserService() {
		return userService;
	}
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public void validate() {
		
	}

	public void prepare() throws Exception 
	{ 
	  // Clear last error messages 
	  clearErrorsAndMessages(); 
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

	@Override
	public void setUser(User user) {
		this.user = user;
		
	}

	public User getUser() {
		return user;
	}
	

}