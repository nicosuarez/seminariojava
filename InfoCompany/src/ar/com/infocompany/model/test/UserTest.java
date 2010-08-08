package ar.com.infocompany.model.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
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
import ar.com.infocompany.repository.hibernate.UserRepository;


public class UserTest {
	private IUnitOfWork unitOfWork = null;
	private static int amountUsers;
	private static UserRepository rep = null;
	private static CompanyRepository comRep = null;
	
	private static void createUsers() {
		amountUsers = 5;
	 	Location location = null;
    	try {
    		location = new Location("Argentina", "Buenos Aires");
    	} catch(InvalidLocationException e) {
    		
    	}
 
    	rep = new UserRepository();
    	Industry industry = new Industry("IT");
    	Job job = new Job(industry,"Programador");
    	User user;
    	
    	for(int i=0; i<amountUsers; i++)
    	{
    		user = new User("Juan " + String.valueOf(i), "123456", "juan" + String.valueOf(i) + "@lopez.com", job, location, 1984);
    		rep.save(user);
    	}
	}
	
	@BeforeClass  
    public static void setUpClass() throws Exception {  
//		ar.com.infocompany.repository.hibernate.SessionFactory.getNewSession();
		comRep = new CompanyRepository();
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
    public void testCreateUser() {
    	String username = "juan";
    	String password = "123456";
    	String email = "a@a.a";
    	int year = 1984;
    	Industry industry = new Industry("IT");
    	Job job = new Job(industry,"Programador");
    	Location location = null;
    	try {
    		location = new Location("Argentina", "Buenos Aires");
    	} catch(InvalidLocationException e) {
    		
    	}
    	  	
    	User user = new User(username, password, email, job, location, year);
    	rep.save(user);
    	amountUsers++;
    	
    	Company company = new Company("Adidas", industry);
    	Critic critic = user.makeCritic("Este es un comentario", job, 1000);
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
    		System.out.println("Job: " + user.getJob().getName() + " (" + user.getJob().getIndustry().getName() + ")");
    		System.out.println("Location: " + user.getLocation().getState() + " (" + user.getLocation().getCountry() + ")");
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
