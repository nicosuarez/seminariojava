/*
 * ViewService
 */
package ar.com.infocompany.services;

import java.util.List;

import ar.com.infocompany.model.Country;
import ar.com.infocompany.model.ICountryRepository;
import ar.com.infocompany.model.IIndustryRepository;
import ar.com.infocompany.model.IItemRepository;
import ar.com.infocompany.model.IViewService;
import ar.com.infocompany.model.Industry;
import ar.com.infocompany.model.Item;

import ar.com.infocompany.repository.hibernate.CountryRepository;
import ar.com.infocompany.repository.hibernate.IndustryRepository;
import ar.com.infocompany.repository.hibernate.ItemRepository;


public class ViewService implements IViewService {
	private static List<Industry> industries = null;
	private static List<Country> countries = null;
	private static List<Item> items= null;
	
	private IIndustryRepository industryRep;
	private ICountryRepository countryRep;
	private IItemRepository itemRep;
	
	public ViewService() {
		industryRep = new IndustryRepository();
		countryRep = new CountryRepository();
		itemRep = new ItemRepository();
		
		if( industries == null){
			industries = industryRep.findAll();
		}
		
		if( countries == null){
			countries = countryRep.findAll();
		}
		
		if( items == null){
			items = itemRep.findAll();
		}
	}
	
	@Override
	public List<Industry> findAllIndustries() {
		return industries;
	}

	@Override
	public List<Country> findAllCountries() {
		return countries;
	}

	@Override
	public List<Item> findAllItems() {
		return items;
	}
	
}
	
// eof
