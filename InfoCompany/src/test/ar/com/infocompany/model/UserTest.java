package test.ar.com.infocompany.model;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.opensymphony.xwork2.interceptor.annotations.After;
import com.opensymphony.xwork2.interceptor.annotations.Before;


import ar.com.infocompany.infraestructure.IUnitOfWork;
import ar.com.infocompany.infraestructure.query.Criteria;
import ar.com.infocompany.infraestructure.query.CriteriaOperator;
import ar.com.infocompany.infraestructure.query.Query;
import ar.com.infocompany.model.*;

import ar.com.infocompany.repository.hibernate.CompanyRepository;
import ar.com.infocompany.repository.hibernate.IndustryRepository;
import ar.com.infocompany.repository.hibernate.UserRepository;


public class UserTest {
	private IUnitOfWork unitOfWork = null;
	private static int amountUsers;
	private static UserRepository rep = null;
	private static CompanyRepository comRep = null;
	private static IIndustryRepository indRep = null;
	private static ICountryRepository countryRep = null;
	
	private static void createUsers() {
		amountUsers = 5;
		
		Country country = countryRep.findBy(1);
		State state = country.getStates().get(0);
 
    	rep = new UserRepository();
		Industry industry = indRep.findBy(1);
		Job job = industry.getJobs().get(0);

    	User user;
    	
    	for(int i=0; i<amountUsers; i++)
    	{
    		user = new User("Juan " + String.valueOf(i), "123456", "juan" + String.valueOf(i) + "@lopez.com", industry.getName(), job.getName(), country.getName(), state.getName(), 1984);
    		rep.save(user);
    	}
	}
	
	@BeforeClass  
    public static void setUpClass() throws Exception {  
//		ar.com.infocompany.repository.hibernate.SessionFactory.getNewSession();
		comRep = new CompanyRepository();
		indRep = new IndustryRepository();
    	createUsers();
    }  
      
    @AfterClass  
    public static void tearDownClass() throws Exception {  
  //  	ar.com.infocompany.repository.hibernate.SessionFactory.getCurrentSession().close();
    }  
    
    @Before  
    public void setUp() {  
    //	IUnitOfWork unitOfWork = new HibernateUnitOfWork();
    	
    }  
      
    @After  
    public void tearDown() {  
    	if(unitOfWork != null) {
    		//unitOfWork.
    	}
    } 
	
    @Test
    public void testCreateUser() throws UserInactiveException {
    	String username = "juan";
    	String password = "123456";
    	String email = "a@a.a";
    	int year = 1984;

		Industry industry = indRep.findBy(1);
		Job job = industry.getJobs().get(0);

		Country country = countryRep.findBy(1);
		State state = country.getStates().get(0);
   	  	
    	User user = new User(username, password, email, industry.getName(), job.getName(), country.getName(), state.getName(), year);
    	rep.save(user);
    	amountUsers++;
    	
    	List<CriticItem> criticItems = new ArrayList<CriticItem>();
		criticItems.add(new CriticItem("Beneficios", 10));
    	
    	Company company = new Company("Adidas", industry);
    	Critic critic = user.makeCritic("Este es un comentario", industry, job, 1000, criticItems);
    	company.addCritic( critic );
    	comRep.save(company);
    	
    	Assert.assertTrue( user.getId() != 0 );
    }
    
   
    @Test
    public void testFindAll() {
    	List<User> users = rep.findAll();
    	Assert.assertEquals(amountUsers, users.size());
    }
    
    @Test
    public void testFindAllAndPrint() {
    	List<User> users = rep.findAll();
    	for(User user : users)
    	{
    		System.out.println("Username: " + user.getUserName());
    		System.out.println("Password: " + user.getPassword());
    		System.out.println("Year: " + user.getBirthdayYear());
    		System.out.println("Job: " + user.getJob().getName() + " (" + user.getIndustry().getName() + ")");
    		System.out.println("Country: " + user.getState() + " (" + user.getCountry() + ")");
    		System.out.println("Email:" + user.getEmail() + "\n");
    	}
    	Assert.assertEquals(amountUsers, users.size());
    }
 
  @Test
    public void testValidateExistingUser() {
    	String username = "Juan 1";
    	String email = "juan1@lopez.com";
    	
    	Query query = new Query();
    	List<Criteria> criterias = new ArrayList<Criteria>();
    	criterias.add(new Criteria(User.NAME, username, CriteriaOperator.Equals));
    	criterias.add(new Criteria(User.EMAIL, email, CriteriaOperator.Equals));
    	query.setCriteria(criterias);
    	List<User> users = rep.findBy(query);

    	Assert.assertTrue( users.size() > 0 );
    }
  
  @Test
  public void testDeleteAllUsers() {
	  List<User> users = rep.findAll();
	  
	  for(User user : users)
	  {
		rep.remove(user);  
	  }
	  
	  Assert.assertTrue(rep.findAll().size() == 0);
  }

}
