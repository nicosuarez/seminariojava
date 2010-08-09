package ar.com.infocompany.presentation;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import ar.com.infocompany.infraestructure.custom_exceptions.ApplicationException;
import ar.com.infocompany.model.Industry;
import ar.com.infocompany.model.Job;
import ar.com.infocompany.model.Location;
import ar.com.infocompany.model.User;
import ar.com.infocompany.model.IUserService;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private IUserService userService;
	
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
		if(user.getUserName().length() == 0 ){
			addFieldError("user.userName","UserName is required");	
		}
		
		if(user.getBirthdayYear() == 0 ){
			addFieldError("user.birthdayYear","BirthDay is required");	
		}
		
	}

	public void prepare() throws Exception 
	{ 
	  // Clear last error messages 
	  clearErrorsAndMessages(); 
	} 
	
	public String execute(){
//			if (user.sgetUserId() == null) {
//				Date today = new Date();
//				user.setCreationDate(today);
//				user.se
//				userService.insertUser(user);
//			}else {
//				userService.updateUser(user);
//			}
		//try {
			//user.setLocation(new Location("Argentina","defw"));
			//user.setJob(new Job(new Industry("IT"), "Programador"));
			//userService.registerUser(user);
		//} catch (ApplicationException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		return "SUCCESS";
	}
	
	public String deleteUser(){
		//userService.deleteCompany(user.getUserId());
		return "success";
	}
	
	public String setUpForInsertOrUpdateUser(){
//		if (user != null && user.getUserId() != null) {
//			user = userService.getUser(user.getUserId());
//		}
		return "success";
	}

}