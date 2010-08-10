package ar.com.infocompany.presentation;

import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport {

	private String name;
	public String execute() {
		name = "Seba";
		this.addActionError("A ocurrido un error3");
		return SUCCESS;
	}
	
	public void validate() {
		this.addActionError("A ocurrido un error");
		this.addActionError("A ocurrido un error2");
		
		this.addFieldError("name","FielderrorMessage");
		
		this.addActionMessage("Mensaje Ok");
	
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
