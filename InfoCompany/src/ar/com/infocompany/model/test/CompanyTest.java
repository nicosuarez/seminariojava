package ar.com.infocompany.model.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import ar.com.infocompany.model.Comment;
import ar.com.infocompany.model.Company;
import ar.com.infocompany.model.Critic;
import ar.com.infocompany.model.ICompanyRepository;
import ar.com.infocompany.model.Industry;
import ar.com.infocompany.repository.hibernate.CompanyRepository;


public class CompanyTest {
	private static int amountCompanies;
	
	public static List<Company> makeCompanies() {
    	Industry industry = new Industry("IT");
    	
        Company company = new Company("Sistran",industry);
        Critic critic = new Critic(50,company, new Comment("Comentario 1"));
        company.addCritic(critic);

        Company company2 = new Company("Globant",industry);
        company2.addCritic(new Critic(100,company2, new Comment("Comentario 2-1")));
        company2.addCritic(new Critic(200,company2, new Comment("Comentario 2-2")));
        
        Industry industry3 = new Industry("Gastronomia");
        Company company3 = new Company("Plaza Mayor",industry3);
        company3.addCritic(new Critic(300,company3, new Comment("Comentario 3-1")));
        company3.addCritic(new Critic(400,company3, new Comment("Comentario 3-2")));
        company3.addCritic(new Critic(500,company3, new Comment("Comentario 3-3")));
        
        List<Company> companyList = new ArrayList<Company>();
        companyList.add(company);
        companyList.add(company2);
        companyList.add(company3);
        
        amountCompanies = companyList.size();
        
        return companyList;
	}
	
	public static List<Company> addCompanyTest(List<Company> companyList) {
		
		for (Company company : companyList) {
			Assert.assertSame(company.getId(), 0);
	        
	        ICompanyRepository companyRepository = new CompanyRepository();
	        companyRepository.save(company);
	        
	        Assert.assertNotSame(company.getId(), 0);   
        }
		return companyList;
    }
	
	public static List<Company> addCompanies()
	{
		return addCompanyTest(makeCompanies());
	}
	
	@BeforeClass
	public static void init() {

		addCompanies();
    }
	
	@Test	
	public void findAllCompaniesTest() {
		//Find all them:
		ICompanyRepository companyRepository = new CompanyRepository();
		List<Company> retriveList = companyRepository.findAll();
    	Assert.assertEquals(amountCompanies, retriveList.size());
	}

	@Test
	public void findAllCriticsByCompanyTest() {
		ICompanyRepository companyRepository = new CompanyRepository();
		List<Company> retriveList = companyRepository.findAll();
		int i = 1;
		for(Company company : retriveList)
		{
			company = companyRepository.findBy(i);
			Assert.assertEquals(i, company.getCritics().size());
			i++;
		}
	}

	@Ignore
	public void testPersistCompany() {
		String name = "Finnegans";
		Industry industry = new Industry("IT");
		Company company = new Company(name, industry);
		Critic critic = new Critic(1200, company, new Comment("Comentario 1200"));
		ICompanyRepository rep = new CompanyRepository();
		company.addCritic(critic);
		rep.save(company);
		Assert.assertTrue(company.getId() != 0);
    }
	
	@Ignore
	public void testPersistCompany2() {
		String name = "Finnegans";
		Industry industry = new Industry("IT");
		Company company = new Company(name, industry);
		Critic critic = new Critic(1200, company, new Comment("Comentario Lalala"));
		ICompanyRepository rep = new CompanyRepository();
		company.addCritic(critic);
		company.addCritic(new Critic(111, company, new Comment("Jojojojo")));
		company.addCritic(new Critic(222, company, new Comment("Jijijiji")));
		rep.save(company);
		Assert.assertTrue(company.getId() != 0);
    }

}
