package test.ar.com.infocompany.model;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ar.com.infocompany.model.Comment;
import ar.com.infocompany.model.Company;
import ar.com.infocompany.model.Country;
import ar.com.infocompany.model.Critic;
import ar.com.infocompany.model.ICompanyRepository;
import ar.com.infocompany.model.ICriticRepository;
import ar.com.infocompany.model.IUserRepository;
import ar.com.infocompany.model.Industry;
import ar.com.infocompany.model.CriticItem;
import ar.com.infocompany.model.Item;
import ar.com.infocompany.model.Job;
import ar.com.infocompany.model.State;
import ar.com.infocompany.model.User;
import ar.com.infocompany.model.UserInactiveException;
import ar.com.infocompany.repository.hibernate.CompanyRepository;
import ar.com.infocompany.repository.hibernate.CriticRepository;
import ar.com.infocompany.repository.hibernate.UserRepository;
import ar.com.infocompany.services.ViewService;

public class CriticTest {
	
	private static ICompanyRepository comRep;
	private static IUserRepository usrRep;
	private static ICriticRepository criRep;
	private static ViewService viewService;
	
	@BeforeClass  
    public static void setUpClass() throws Exception {  
		ar.com.infocompany.repository.hibernate.SessionFactory.getNewSession();
		comRep = new CompanyRepository();
		usrRep = new UserRepository();
		criRep = new CriticRepository();
		viewService = new ViewService();
		addCritics();
    }  
      
    @AfterClass  
    public static void tearDownClass() throws Exception {  
    	ar.com.infocompany.repository.hibernate.SessionFactory.getCurrentSession().close();
    }  
      
    public static void addCritics() throws UserInactiveException {
		String name = "Coca Cola";

		Industry industry = viewService.findAllIndustries().get(1);
		Job job = industry.getJobs().get(0);
		Company company = new Company(name, industry);
		Country country = viewService.findAllCountries().get(1);
		State state = country.getStates().get(0);
		Item item1 = viewService.findAllItems().get(0);
		Item item2 = viewService.findAllItems().get(1);
		
		
		List<CriticItem> criticItems = new ArrayList<CriticItem>();
		
		CriticItem workEnviromentItem = new CriticItem(item1.getName(), 10);
		CriticItem salaryItem = new CriticItem(item2.getName(), 5);
		criticItems.add(workEnviromentItem);
		criticItems.add(salaryItem);
		
		User user = null;
		user = new User("Sebastian", 
							"password", 
							"seba@hotmail.com", 
							industry.getName(),
							job.getName(),
							country.getName(),
							state.getName(), 
							1984);
		
		Critic critic = user.makeCritic("Esta empresa es lo mejor", industry, job, 5000, criticItems);
		
		company.addCritic(critic);
		
		usrRep.save(user);
		comRep.save(company);
    }
   
    
    @Test
	public void testUserCritic() throws UserInactiveException {
		String name = "Finnegans";
		Industry industry = viewService.findAllIndustries().get(0);
		Job job = industry.getJobs().get(0);
		Company company = new Company(name, industry);
		Country country = viewService.findAllCountries().get(0);
		State state = country.getStates().get(0);
				
		Item item1 = viewService.findAllItems().get(0);
		Item item2 = viewService.findAllItems().get(1);
		
		CriticItem workEnviromentItem = new CriticItem(item1.getName(), 6);
		CriticItem salaryItem = new CriticItem(item2.getName(), 6);
		
		List<CriticItem> criticItems = new ArrayList<CriticItem>();
		criticItems.add(workEnviromentItem);
		criticItems.add(salaryItem);
		
		User user = new User("nsuarez", 
								"password", 
								"nsuarez@hotmail.com", 
								industry.getName(),
								job.getName(),
								country.getName(),
								state.getName(),
								1984);
		
		Critic critic = user.makeCritic("mi comentario es grosso", industry, job, 1200, criticItems);

		company.addCritic(critic);
		
		usrRep.save(user);
		comRep.save(company);

		Assert.assertTrue(critic.getId() != 0);
    }
    
    @Test
    public void testFindCritic() {
    	Company company = comRep.findBy(1);
    	Critic critic = company.getLastCritic();
    	System.out.println("Comentario: " + critic.getAuthorComment().getText());

    	List<CriticItem> criticItems = critic.getItems();
    	for(CriticItem criticItem : criticItems)
    		System.out.println(criticItem.getTag() + ": " + criticItem.getScore());
    	
		Assert.assertTrue( critic.getId() != 0 );
		Assert.assertTrue( criticItems.size() > 0 );
    }    
    
    @Test
    public void testAddReply() {
		User user = null;
		Industry industry = viewService.findAllIndustries().get(0);
		Job job = industry.getJobs().get(0);
		Country country = viewService.findAllCountries().get(0);
		State state = country.getStates().get(0);
		
		user = new User("Juancito", 
							"password", 
							"juancito@hotmail.com", 
							industry.getName(),
							job.getName(),
							country.getName(),
							state.getName(),
							1984);
		usrRep.save(user);
		
		Comment comment = new Comment(user, "Tu comentario es una poronga");
    	Company company = comRep.findBy(1);
    	Critic critic = company.getLastCritic();
    	critic.addReply(comment);
    	criRep.save(critic);
    	Assert.assertTrue(comment.getId() != 0 );
    }
    
    @Test
    public void testFindReply() {
    	Company company = comRep.findBy(1);
    	Critic critic = company.getLastCritic();
    	System.out.println("Comentario de la critica (" + critic.getAuthorComment().getAuthor().getUserName() + ") : " + critic.getAuthorComment().getText());
    	
    	List<Comment> replies = critic.getReplies();
    	
    	for(Comment comment : replies )
    		System.out.println("Respuesta (" + comment.getAuthor().getUserName() + ") : " + comment.getText());
    	
    	Assert.assertTrue(replies.size() == 1 );
    }
    
    @Test
    public void testFindAll() {
    	List<Critic> critics = criRep.findAll();
    	
    	for(Critic critic : critics)
    	{
    		System.out.println("N°: " + critic.getId());
    		System.out.println("Autor: " + critic.getAuthor().getUserName());
    		System.out.println("Fecha: " + critic.getDate());
    		System.out.println(critic.getJob().getName() + " (" + critic.getIndustry().getName() + ")");
    		System.out.println("Salary: " + critic.getSalary());

    		List<CriticItem> criticItems = critic.getItems();
        	for(CriticItem criticItem : criticItems)
        		System.out.println("	"  + criticItem.getTag() + ": " + criticItem.getScore());
        	System.out.println("Comentario: " + critic.getAuthorComment().getText());
    	}
    	Assert.assertTrue(critics.size() > 1 );
    }
    
    @Test
    public void testDeleteCritic() {
    	Company company = comRep.findBy(1);
    	Critic critic = company.getLastCritic();
    	company.removeCritic(critic);
    	comRep.save(company);
    	Assert.assertEquals( null, criRep.findBy(critic.getId()) );
    }
}
