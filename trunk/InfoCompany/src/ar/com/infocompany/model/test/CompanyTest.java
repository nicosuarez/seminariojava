package ar.com.infocompany.model.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.opensymphony.xwork2.interceptor.annotations.After;
import com.opensymphony.xwork2.interceptor.annotations.Before;

import ar.com.infocompany.infraestructure.IUnitOfWork;
import ar.com.infocompany.infraestructure.custom_exceptions.InvalidLocationException;
import ar.com.infocompany.infraestructure.query.Criteria;
import ar.com.infocompany.infraestructure.query.CriteriaOperator;
import ar.com.infocompany.infraestructure.query.Query;
import ar.com.infocompany.model.*;

import ar.com.infocompany.repository.hibernate.CompanyRepository;
import ar.com.infocompany.repository.hibernate.IndustryRepository;
import ar.com.infocompany.repository.hibernate.UserRepository;


public class CompanyTest {
	private static int amountCompanies;
	private IUnitOfWork unitOfWork = null;
	private static ICompanyRepository comRep;
	private static IUserRepository usrRep;
	private static IIndustryRepository indRep;
	
	@BeforeClass  
    public static void setUpClass() throws Exception {  
		ar.com.infocompany.repository.hibernate.SessionFactory.getNewSession();
		comRep = new CompanyRepository();
		usrRep = new UserRepository();
		indRep = new IndustryRepository();
    }  
      
    @AfterClass  
    public static void tearDownClass() throws Exception {  
    	ar.com.infocompany.repository.hibernate.SessionFactory.getCurrentSession().close();
    }  
      
    @Before  
    public void setUp() {  
    	
    }  
      
    @After  
    public void tearDown() {  
    	if(unitOfWork != null) {
    		//unitOfWork.
    	}
    } 
	
	public static List<Company> makeCompanies() {
    	Industry industry = new Industry("IT");
    	
        Company company = new Company("Sistran",industry);

        Company company2 = new Company("Globant",industry);
        
        Industry industry3 = new Industry("Gastronomia");
        Company company3 = new Company("Plaza Mayor",industry3);
        
        List<Company> companyList = new ArrayList<Company>();
        companyList.add(company);
        companyList.add(company2);
        companyList.add(company3);
        
        comRep.save(company);
        comRep.save(company2);
        comRep.save(company3);
        
        amountCompanies = companyList.size();
        
        return companyList;
	}
	
		
	@BeforeClass
	public static void init() {

		makeCompanies();
    }
	
	@Test	
	public void findAllCompaniesTest() {
		//Find all them:
		ICompanyRepository companyRepository = new CompanyRepository();
		List<Company> retriveList = companyRepository.findAll();
    	Assert.assertEquals(amountCompanies, retriveList.size());
	}

	@Ignore
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
	public void findAllCommentsByCompanyTest() {
		ICompanyRepository companyRepository = new CompanyRepository();
		List<Company> retriveList = companyRepository.findAll();
		int i = 1;
		for(Company company : retriveList)
		{
			company = companyRepository.findBy(i);
			Assert.assertEquals(i, company.getCritics().size());

			for(Critic critic : company.getCritics())
			{
				Assert.assertTrue(critic.getAuthorComment() != null);
				System.out.println(critic.getAuthorComment().getText());
			}
			i++;
		}
	}
	
	@Test
	public void testPersistCompany() {
		String name = "Finnegans";
		Industry industry = new Industry("IT");
		Company company = new Company(name, industry);
		User user = null;
		try {
			user = new User("nsuarez", 
								"password", 
								"nsuarez@hotmail.com", 
								new Job(industry,"Programador"), 
								new Location("Argentina","Capital Federal"), 
								1984);
			usrRep.save(user);
		} catch (InvalidLocationException e) {
			e.printStackTrace();
		}
		Job job = new Job(industry, "trabajo a criticar");
							
		Critic critic = user.makeCritic("esta company es barata", job, 2800);
		
		company.addCritic(critic);
		comRep.save(company);
		Assert.assertTrue(company.getId() != 0);
    }
	
	@Test
	public void testPersistCompanyWithoutCritic() {
		String name = "Villa del Sur";
		Industry industry = new Industry("Alimentos");
		Company company = new Company(name, industry);
		comRep.save(company);
		Assert.assertTrue(company.getId() != 0);
    }
	
	@Test
	public void testUserPersistCompanyWithCritic() {
		String name = "HP";
		Industry industry = new Industry("IT");
		Company company = new Company(name, industry);
		
		Item workEnviromentItem = new Item("Ambiente Laboral", 10);
		
		User user = null;
		try {
			user = new User("scamjayi", 
								"password", 
								"scamjayi@hotmail.com", 
								new Job(industry,"Programador"), 
								new Location("Argentina","Capital Federal"), 
								1984);
		} catch (InvalidLocationException e) {
			e.printStackTrace();
		}
		
		Job job = new Job(industry, "Jefe de Sistemas");
							
		Critic critic = user.makeCritic("me gusta criticar", job, 3333);
		critic.addItem(workEnviromentItem);
		company.addCritic(critic);
		
		indRep.save(industry);
		usrRep.save(user);
		comRep.save(company);
		
		Assert.assertTrue(company.getId() != 0);
    }
	
	@Test
	public void testUserCriticReply() throws InvalidLocationException {
		
		testUserPersistCompanyWithCritic();
		
		User user = new User("jlopez", 
				"password", 
				"jlopez@hotmail.com", 
				new Job(new Industry("ITMM"),"Programador"), 
				new Location("Argentina","Buenos Aires"), 
				1984);
		
		usrRep.save(user);
		
    	Query query = new Query();
    	List<Criteria> criterias = new ArrayList<Criteria>();
    	criterias.add(new Criteria(Company.NAME, "HP", CriteriaOperator.Equals));
    	query.setCriteria(criterias);
    	Company company = comRep.findBy(query).get(0);
    	
		company.getLastCritic().addReply(user.comment("Que buena empresa!!"));		
		comRep.save(company);
		
		Assert.assertTrue(true);
    }
	
	@Test
	public void testRetriveCriticsByCompany() throws InvalidLocationException {
		
		testUserCriticReply();
		
		Query query = new Query();
    	List<Criteria> criterias = new ArrayList<Criteria>();
    	criterias.add(new Criteria(Company.NAME, "HP", CriteriaOperator.Equals));
    	query.setCriteria(criterias);
    	Company company = comRep.findBy(query).get(0);
    	
		Assert.assertNotNull(company);
		Assert.assertNotNull(company.getLastCritic());
		Assert.assertNotNull(company.getLastCritic().getAuthorComment().getText());
		
		Comment reply = company.getLastCritic().getReplies().get(1);
		
		System.out.println(reply.getAuthor().getUserName());
		System.out.println(reply.getText());
		
		Assert.assertEquals(reply.getAuthor().getUserName() , "jlopez");
		Assert.assertEquals(reply.getText() , "Que buena empresa!!");
    }
	
	@Test
	public void testDeleteCompany() {
		Query query = new Query();
    	List<Criteria> criterias = new ArrayList<Criteria>();
    	criterias.add(new Criteria(Company.NAME, "HP", CriteriaOperator.Equals));
    	query.setCriteria(criterias);
    	List<Company> companies = comRep.findBy(query);
    	
    	for(Company company : companies)
    	{
    		comRep.remove(company);
    	}
    	
    	Assert.assertTrue( comRep.findBy(query).size() == 0 );
    	
	}

}
