package ar.com.infocompany.actions;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.mcavallo.opencloud.Cloud;
import org.mcavallo.opencloud.Tag;

import ar.com.infocompany.entities.Company;
import ar.com.infocompany.entities.Field;
import ar.com.infocompany.entities.User;
import ar.com.infocompany.services.IModelService;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private IModelService modelService;
	
	private User user; 
	
	public IModelService getModelService() {
		return modelService;
	}
	
	public void setModelService(IModelService modelService) {
		this.modelService = modelService;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public String createOrUpdateUser(){
			if (user.getUserId() == null) {
				Date today = new Date();
				user.setCreationDate(today);
				modelService.insertUser(user);
			}else {
				modelService.updateUser(user);
			}
		return "success";
	}
	
	public String deleteUser(){
		modelService.deleteCompany(user.getUserId());
		return "success";
	}
	
	public String setUpForInsertOrUpdateUser(){
		if (user != null && user.getUserId() != null) {
			user = modelService.getUser(user.getUserId());
		}
		return "success";
	}

}