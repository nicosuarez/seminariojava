package ar.com.infocompany.presentation;

import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport {

	private String name;
	public String execute() {
	
		return SUCCESS;
	}
	
	public void validate() {
	
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
