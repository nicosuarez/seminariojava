package ar.com.infocompany.presentation;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import ar.com.infocompany.infraestructure.exceptions.ApplicationException;
import ar.com.infocompany.model.User;
import ar.com.infocompany.model.IUserService;
import ar.com.infocompany.services.UserService;

import com.opensymphony.xwork2.ActionSupport;

/*
 * The Login action takes a username and password from the request
 * and authenticates those tokens agains the portfolioService objects
 * authentication methods.  If the user is valid, the user object
 * is stored in the session map. 
 * 
 * To receive the session map, this action implements the sessionAware
 * interface.  This decouples the action from the servlet API.  Of course,
 * the action could use the ActionContext to get this map, or even the 
 * underlying Servlet Session object, but these would be needless bindings 
 * to the Servlet API, certainly complicating testing. 
 */

public class LoginAction extends ActionSupport implements SessionAware {

	private IUserService userService;

	public String execute(){
		if(userService == null)
			userService = new UserService();
		User user;
		try {
			user = getUserService().authenticateUser( getUsername(), getPassword() );
			session.put( "User", user );
		} catch (ApplicationException e) {
			/* User not valid, return to input page. */
			return INPUT;
		} 
		return SUCCESS;
	}
	
	
	/* JavaBeans Properties to Receive Request Parameters */
	
	private String username;
	private String password;
	private Map session;


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void validate(){

		/* Check that fields are not empty */
//		if ( getPassword().length() == 0 ){			
//			addFieldError( "password", getText("password.required") );
//		}
//		if ( getUsername().length() == 0 ){			
//			addFieldError( "username", getText("username.required") );
//		}

	}

	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public void setSession(Map session) {
		this.session = session;
		
	}
	
	

}
