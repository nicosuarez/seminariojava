/*
 * IndustryService
 */
package ar.com.infocompany.services;

import java.util.List;

import ar.com.infocompany.model.IIndustryRepository;
import ar.com.infocompany.model.IIndustryService;
import ar.com.infocompany.model.Industry;

import ar.com.infocompany.repository.hibernate.IndustryRepository;


public class IndustryService implements IIndustryService {
	private static List<Industry> industries = null;
	private IIndustryRepository indRepository;
	
	public IndustryService() {
		indRepository = new IndustryRepository();
		if( industries == null){
			industries = indRepository.findAll();
		}
	}
	
	@Override
	public List<Industry> findAllIndustries() {
		return industries;
	}
	
}
	
// eof
