package ar.com.infocompany.presentation;

import ar.com.infocompany.infraestructure.exceptions.ApplicationException;
import ar.com.infocompany.model.IUserService;
import ar.com.infocompany.model.User;

import com.opensymphony.xwork2.ActionSupport;

public class CreateUserAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private IUserService userService;
	
	private String userName;
	private String password;
	private String email;
	private int birthdayYear;
	private String industryName;
	private String jobName;
	private String country;
	private String state; 
	
	public String execute(){
		try {
			User user = new User(userName, password, email, industryName, jobName, country, state, birthdayYear);
			userService.registerUser(user);
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
		
		if( getUserName().length() == 0 ){
			addFieldError("userName","UserName is required");	
		}
		
		if( getBirthdayYear() == 0 ){
			addFieldError("birthdayYear","BirthDay is required");	
		}
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBirthdayYear() {
		return birthdayYear;
	}

	public void setBirthdayYear(int birthdayYear) {
		this.birthdayYear = birthdayYear;
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
	

}