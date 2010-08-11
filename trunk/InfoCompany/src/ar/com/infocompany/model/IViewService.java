package ar.com.infocompany.model;

import java.util.List;

public interface IViewService {
	public List<Industry> findAllIndustries();
	public List<Country> findAllCountries();
	public List<Item> findAllItems();
	
}
