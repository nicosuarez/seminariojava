package ar.com.infocompany.presentation;

import java.util.List;

import ar.com.infocompany.model.Country;
import ar.com.infocompany.model.IViewService;
import ar.com.infocompany.model.Industry;
import ar.com.infocompany.services.ViewService;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	private IViewService viewService = new ViewService();
	
	private List<Country> countries;
	private List<Industry> industries;

	
	public String execute(){
			
		countries = viewService.findAllCountries();
		industries = viewService.findAllIndustries();
		
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

}