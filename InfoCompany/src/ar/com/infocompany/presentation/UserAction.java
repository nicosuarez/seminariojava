package ar.com.infocompany.presentation;

import java.util.List;

import ar.com.infocompany.model.Country;
import ar.com.infocompany.model.IViewService;
import ar.com.infocompany.model.Industry;
import ar.com.infocompany.model.User;
import ar.com.infocompany.services.ViewService;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements UserAware {

	private static final long serialVersionUID = 1L;

	private IViewService viewService = new ViewService();
	
	private List<Country> countries;
	private List<Industry> industries;
	private User user;
	
	public String execute(){
		
		countries = viewService.findAllCountries();
		industries = viewService.findAllIndustries();
		
		if(user == null){
			return INPUT;
		}	
		
		return SUCCESS;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public List<Industry> getIndustries() {
		return industries;
	}

	public void setIndustries(List<Industry> industries) {
		this.industries = industries;
	}

	public IViewService getViewService() {
		return viewService;
	}

	public void setViewService(IViewService viewService) {
		this.viewService = viewService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}