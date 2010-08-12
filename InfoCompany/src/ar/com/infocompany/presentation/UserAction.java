package ar.com.infocompany.presentation;

import ar.com.infocompany.infraestructure.exceptions.ApplicationException;
import ar.com.infocompany.model.IViewService;
import ar.com.infocompany.model.Industry;
import ar.com.infocompany.model.User;
import ar.com.infocompany.model.IUserService;
import ar.com.infocompany.services.UserService;
import ar.com.infocompany.services.ViewService;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private IUserService userService;
	private IViewService viewService;
	
	private User user; 
	
	public IUserService getUserService() {
		return userService;
	}
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void validate() {
		if(user == null)
			return;
		if( user.getUserName().length() == 0 ){
			addFieldError("user.userName","UserName is required");	
		}
		
		if( user.getBirthdayYear() == 0 ){
			addFieldError("user.birthdayYear","BirthDay is required");	
		}
		
	}

	public void prepare() throws Exception 
	{ 
	  // Clear last error messages 
	  clearErrorsAndMessages(); 
	} 
	
	public String execute(){
		
		if(userService == null)
			userService = new UserService();
		
		if(viewService == null)
			viewService = new ViewService();
		
		if (user.getId() == 0) {
			//TODO: pedir la industria en el formulario
			Industry industry = viewService.findAllIndustries().get(0);
			user.setJob(industry.getJobs().get(0));
			user.setIndustry(industry);
			
			try {
				userService.registerUser(user);
			} catch (ApplicationException e) {
				e.printStackTrace();
				return INPUT;
			}
		}
		return SUCCESS;
	}
	
	public String deleteUser(){
		//userService.deleteCompany(user.getUserId());
		return SUCCESS;
	}
	
	public String setUpForInsertOrUpdateUser(){
//		if (user != null && user.getUserId() != null) {
//			user = userService.getUser(user.getUserId());
//		}
		return SUCCESS;
	}

}