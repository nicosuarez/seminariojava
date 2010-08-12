package test.ar.com.infocompany.model;

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
import ar.com.infocompany.infraestructure.exceptions.InvalidLocationException;
import ar.com.infocompany.infraestructure.query.Criteria;
import ar.com.infocompany.infraestructure.query.CriteriaOperator;
import ar.com.infocompany.infraestructure.query.Query;
import ar.com.infocompany.model.*;

import ar.com.infocompany.repository.hibernate.CompanyRepository;
import ar.com.infocompany.repository.hibernate.CountryRepository;
import ar.com.infocompany.repository.hibernate.IndustryRepository;
import ar.com.infocompany.repository.hibernate.ItemRepository;
import ar.com.infocompany.repository.hibernate.UserRepository;
import ar.com.infocompany.repository.hibernate.HibernateUnitOfWork;

public class CompanyTest {
	private static int amountCompanies;
	private static IUnitOfWork unitOfWork = null;
	private static ICompanyRepository comRep;
	private static IUserRepository usrRep;
	private static IIndustryRepository indRep;
	private static ICountryRepository countryRep;
	private static IItemRepository itemRep;
	
	@BeforeClass  
    public static void setUpClass() throws Exception {  
		//ar.com.infocompany.repository.hibernate.SessionFactory.getNewSession();
		comRep = new CompanyRepository();
		usrRep = new UserRepository();
		indRep = new IndustryRepository();
		countryRep = new CountryRepository();
		itemRep = new ItemRepository();
    }  
      
    @AfterClass  
    public static void tearDownClass() throws Exception {  
    	//ar.com.infocompany.repository.hibernate.SessionFactory.getCurrentSession().close();
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
		Industry industry = indRep.findBy(1);

        Company company = new Company("Sistran",industry);
        Company company2 = new Company("Globant",industry);
        

		Industry industry2 = indRep.findBy(2);
        Company company3 = new Company("Plaza Mayor",industry2);
      
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

		//makeCompanies();
    }
	
	@Ignore	
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
	
	@Ignore
	public void testPersistCompany() throws UserInactiveException {
		String name = "Finnegans";
		Industry industry = indRep.findBy(1);
		Job job = industry.getJobs().get(0);
		Company company = new Company(name, industry);
		Country country = countryRep.findBy(1);
		State state = country.getStates().get(0);
		User user = null;
		
		user = new User("nsuarez", 
							"password", 
							"nsuarez@hotmail.com", 
							industry.getName(),
							job.getName(),
							country.getName(),
							state.getName(),
							1984);
			usrRep.save(user);
		
		List<Item> listItems = itemRep.findAll();
		List<CriticItem> criticItems = new ArrayList<CriticItem>();
		criticItems.add(new CriticItem(listItems.get(0).getName(), 10));
		criticItems.add(new CriticItem(listItems.get(1).getName(), 4));
			
		Critic critic = user.makeCritic("esta company es barata", industry, job, 2800, criticItems);
		critic.setCountry(country.getName());
		critic.setState(state.getName());
		
		company.addCritic(critic);
		comRep.save(company);
		Assert.assertTrue(company.getId() != 0);
    }
	
	@Ignore
	public void testPersistCompanyWithoutCritic() {
		String name = "Villa del Sur";

		Industry industry = indRep.findBy(1);
		Company company = new Company(name, industry);
		comRep.save(company);
		Assert.assertTrue(company.getId() != 0);
    }
	
	@Ignore
	public void testUserPersistCompanyWithCritic() throws UserInactiveException {
		String name = "HP";
		Industry industry = indRep.findBy(1);
		Job job = industry.getJobs().get(0);
		Company company = new Company(name, industry);
		Country country = countryRep.findBy(1);
		State state = country.getStates().get(0);
		
		
		Item item = itemRep.findAll().get(0);
		List<CriticItem> criticItems = new ArrayList<CriticItem>();
		CriticItem workEnviromentItem = new CriticItem(item.getName(), 10);
		criticItems.add(workEnviromentItem);
	
		User user = null;
		user = new User("scamjayi", 
								"password", 
								"scamjayi@hotmail.com", 
								industry.getName(),
								job.getName(),
								country.getName(),
								state.getName(), 
								1984);
				
		Critic critic = user.makeCritic("me gusta criticar", industry, job, 3333, criticItems);
		critic.addItem(workEnviromentItem);
		company.addCritic(critic);
		
		usrRep.save(user);
		comRep.save(company);
		
		Assert.assertTrue(company.getId() != 0);
    }
	
	@Ignore
	public void testUserCriticReply() throws InvalidLocationException, UserInactiveException {
		
		testUserPersistCompanyWithCritic();

		Industry industry = indRep.findBy(1);
		Job job = industry.getJobs().get(0);
		Country country = countryRep.findBy(1);
		State state = country.getStates().get(0);
		
		User user = new User("jlopez", 
				"password", 
				"jlopez@hotmail.com", 
				industry.getName(),
				job.getName(),
				country.getName(),
				state.getName(),
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
	
	@Ignore
	public void testRetriveCriticsByCompany() throws InvalidLocationException, UserInactiveException {
		
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
	
	@Ignore
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
	
	@Ignore
	public void testUnitOfWork() {
		User user = null;
		Company company = null;
		
		unitOfWork = new HibernateUnitOfWork();
		comRep.inyect(unitOfWork);
		usrRep.inyect(unitOfWork);
		Country country = countryRep.findBy(1);
		State state = country.getStates().get(0);
					
		Industry industry = indRep.findBy(1);
		Job job = industry.getJobs().get(0);
		
		try{ 
			user = new User("Nicolas", "123456", "nsuarez@gmail.com", industry.getName(), job.getName(), industry.getName(), state.getName(), 1983);
			usrRep.save(user);
			
			company = new Company("Engenus", industry);
			Critic critic = new Critic();
			company.addCritic(critic);
			comRep.save(company);
			
			unitOfWork.commit();
		}		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		Assert.assertTrue( user.isTransient() );
		Assert.assertTrue( company.isTransient() );
	}
}
