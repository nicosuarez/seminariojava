package ar.com.infocompany.model.test;

import java.util.List;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ar.com.infocompany.infraestructure.custom_exceptions.InvalidLocationException;
import ar.com.infocompany.model.Comment;
import ar.com.infocompany.model.Company;
import ar.com.infocompany.model.Critic;
import ar.com.infocompany.model.ICompanyRepository;
import ar.com.infocompany.model.ICriticRepository;
import ar.com.infocompany.model.IIndustryRepository;
import ar.com.infocompany.model.IUserRepository;
import ar.com.infocompany.model.Industry;
import ar.com.infocompany.model.Item;
import ar.com.infocompany.model.Job;
import ar.com.infocompany.model.Location;
import ar.com.infocompany.model.User;
import ar.com.infocompany.repository.hibernate.CompanyRepository;
import ar.com.infocompany.repository.hibernate.CriticRepository;
import ar.com.infocompany.repository.hibernate.IndustryRepository;
import ar.com.infocompany.repository.hibernate.UserRepository;

public class CriticTest {
	
	private static ICompanyRepository comRep;
	private static IUserRepository usrRep;
	private static IIndustryRepository indRep;
	private static ICriticRepository criRep;
	
	@BeforeClass  
    public static void setUpClass() throws Exception {  
		ar.com.infocompany.repository.hibernate.SessionFactory.getNewSession();
		comRep = new CompanyRepository();
		usrRep = new UserRepository();
		indRep = new IndustryRepository();
		criRep = new CriticRepository();
		addCritics();
    }  
      
    @AfterClass  
    public static void tearDownClass() throws Exception {  
    	ar.com.infocompany.repository.hibernate.SessionFactory.getCurrentSession().close();
    }  
      
    public static void addCritics() {
		String name = "Coca Cola";

		Industry industry = indRep.findBy(1);
		Job job = industry.getJobs().get(0);

		Company company = new Company(name, industry);
		
		Item workEnviromentItem = new Item("Ambiente Laboral", 10);
		Item salaryItem = new Item("Salario", 5);
		
		User user = null;
		try {
			user = new User("Sebastian", 
								"password", 
								"seba@hotmail.com", 
								industry.getName(),
								job.getName(),
								new Location("Argentina","Capital Federal"), 
								1984);
		} catch (InvalidLocationException e) {
			e.printStackTrace();
		}
		
		Critic critic = user.makeCritic("Esta empresa es lo mejor", industry, job, 5000);
		critic.addItem(workEnviromentItem);
		critic.addItem(salaryItem);
		
		company.addCritic(critic);
		
		usrRep.save(user);
		comRep.save(company);
    }
   
    
    @Test
	public void testUserCritic() {
		String name = "Finnegans";
		Industry industry = indRep.findBy(1);
		Job job = industry.getJobs().get(0);
		Company company = new Company(name, industry);
		
		Item workEnviromentItem = new Item("Ambiente Laboral", 10);
		Item salaryItem = new Item("Salario", 5);
		
		User user = null;
		try {
			user = new User("nsuarez", 
								"password", 
								"nsuarez@hotmail.com", 
								industry.getName(),
								job.getName(),
								new Location("Argentina","Capital Federal"), 
								1984);
		} catch (InvalidLocationException e) {
			e.printStackTrace();
		}
		
		Critic critic = user.makeCritic("mi comentario es grosso", industry, job, 1200);
		critic.addItem(workEnviromentItem);
		critic.addItem(salaryItem);
		
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

    	List<Item> items = critic.getItems();
    	for(Item item : items)
    		System.out.println(item.getTag() + ": " + item.getScore());
    	
		Assert.assertTrue( critic.getId() != 0 );
		Assert.assertTrue( items.size() > 0 );
    }    
    
    @Test
    public void testAddReply() {
		User user = null;
		Industry industry = indRep.findBy(1);
		Job job = industry.getJobs().get(0);
		try {
			user = new User("Juancito", 
								"password", 
								"juancito@hotmail.com", 
								industry.getName(),
								job.getName(),
								new Location("Argentina","Capital Federal"), 
								1984);
		} catch (InvalidLocationException e) {
			e.printStackTrace();
		}
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

    		List<Item> items = critic.getItems();
        	for(Item item : items)
        		System.out.println("	"  + item.getTag() + ": " + item.getScore());
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
