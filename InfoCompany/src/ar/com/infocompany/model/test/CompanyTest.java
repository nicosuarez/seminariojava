package ar.com.infocompany.model.test;

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
	
//	public static List<Company> makeCompanies() {
//    	Industry industry = new Industry("IT");
//    	
//        Company company = new Company("Sistran",industry);
//        Critic critic = new Critic(50,company, new Comment("Comentario 1"));
//        company.addCritic(critic);
//
//        Company company2 = new Company("Globant",industry);
//        company2.addCritic(new Critic(100,company2, new Comment("Comentario 2-1")));
//        company2.addCritic(new Critic(200,company2, new Comment("Comentario 2-2")));
//        
//        Industry industry3 = new Industry("Gastronomia");
//        Company company3 = new Company("Plaza Mayor",industry3);
//        company3.addCritic(new Critic(300,company3, new Comment("Comentario 3-1")));
//        company3.addCritic(new Critic(400,company3, new Comment("Comentario 3-2")));
//        company3.addCritic(new Critic(500,company3, new Comment("Comentario 3-3")));
//        
//        List<Company> companyList = new ArrayList<Company>();
//        companyList.add(company);
//        companyList.add(company2);
//        companyList.add(company3);
//        
//        amountCompanies = companyList.size();
//        
//        return companyList;
//	}
	
	public static List<Company> addCompanyTest(List<Company> companyList) {
		
		for (Company company : companyList) {
			Assert.assertSame(company.getId(), 0);
	        
	        ICompanyRepository companyRepository = new CompanyRepository();
	        companyRepository.save(company);
	        
	        Assert.assertNotSame(company.getId(), 0);   
        }
		return companyList;
    }
	
//	public static List<Company> addCompanies()
//	{
//		return addCompanyTest(makeCompanies());
//	}
	
//	@BeforeClass
//	public static void init() {
//
//		addCompanies();
//    }
	
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
	
//	@Test
//	public void testPersistCriticWithNullComment() {
//		String name = "CompanyNullComment";
//		Industry industry = new Industry("IT");
//		Company company = new Company(name, industry);
//		Critic critic = new Critic(1200, company);
//		ICompanyRepository rep = new CompanyRepository();
//		company.addCritic(critic);
//		rep.save(company);
//		
//		Company retrivedCompany = rep.findBy(company.getId());
//		Assert.assertNotNull(retrivedCompany.getLastCritic());
//		Assert.assertNull(retrivedCompany.getLastComment());
//    }
//	
//	@Test
//	public void testPersistCriticWithComment() {
//		
//		testPersistCriticWithNullComment();
//		
//		String name = "CompanyComment";
//		Industry industry = new Industry("IT");
//		Company company = new Company(name, industry);
//		Critic critic = new Critic(990, company, new Comment("hola"));
//		ICompanyRepository rep = new CompanyRepository();
//		company.addCritic(critic);
//		rep.save(company);
//		
//		Company retrivedCompany = rep.findBy(company.getId());
//		System.out.println(retrivedCompany.getId() + " " + retrivedCompany.getLastCritic().getId());
//		Assert.assertEquals(critic.getComment().getText(), retrivedCompany.getLastCritic().getComment().getText());
//		Assert.assertEquals(critic.getSalary(), retrivedCompany.getLastCritic().getSalary());
//		Assert.assertEquals(critic.getCompany().getName(), retrivedCompany.getName());
//		Assert.assertEquals(critic.getCompany().getIndustry().getValue(), retrivedCompany.getIndustry().getValue());
//		Assert.assertEquals(critic.getComment().getText(), retrivedCompany.getLastCritic().getComment().getText());
//		Assert.assertEquals(critic.getComment().getText(), retrivedCompany.getLastComment().getText());
//		
//		System.out.println(retrivedCompany.getLastCritic().getSalary());
//    }
	
	@Ignore
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
		} catch (InvalidLocationException e) {
			e.printStackTrace();
		}
		Job job = new Job(industry, "trabajo a criticar");
							
		Critic critic = user.makeCritic("esta company es barata", job, 2800);
		
		company.addCritic(critic);
		comRep.save(company);
		Assert.assertTrue(company.getId() != 0);
    }
	
	@Ignore
	public void testPersistCompanyWithoutCritic() {
		String name = "Finnegans";
		Industry industry = new Industry("IT");
		Company company = new Company(name, industry);
		
//		User user = new User("nsuarez", 
//							"password", 
//							"nsuarez@hotmail.com", 
//							new Job(industry,"Programador"), 
//							new Location("Argentina","Capital Federal"), 
//							1984);
//		Job job = new Job(industry, "trabajo a criticar");
							
//		Critic critic = new Critic(user, company, "hola mundo", job, 3333);
		
		indRep.save(industry);
//		company.addCritic(critic);
		comRep.save(company);
		Assert.assertTrue(company.getId() != 0);
    }
	
	@Ignore
	public void testUserPersistCompanyWithCritic() {
		String name = "Finnegans";
		Industry industry = new Industry("IT");
		Company company = new Company(name, industry);
		
		Item workEnviromentItem = new Item("Ambiente Laboral", 10);
		
		User user = null;
		try {
			user = new User("nsuarez", 
								"password", 
								"nsuarez@hotmail.com", 
								new Job(industry,"Programador"), 
								new Location("Argentina","Capital Federal"), 
								1984);
		} catch (InvalidLocationException e) {
			e.printStackTrace();
		}
		
		Job job = new Job(industry, "trabajo a criticar");
							
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
		
		User user = new User("scamjayi", 
				"password", 
				"scamjayi@hotmail.com", 
				new Job(new Industry("ITMM"),"Programador"), 
				new Location("Argentina","Buenos Aires"), 
				1984);
		
		usrRep.save(user);
		
		Company company = comRep.findBy(1);
		company.getLastCritic().addReply(user.comment("Que buena empresa!!"));		
		comRep.save(company);
		
		Assert.assertTrue(true);
    }
	
	@Ignore
	public void testRetriveCriticsByCompany() throws InvalidLocationException {
		
		testUserCriticReply();
		
		Company newCompany = comRep.findBy(1);
		Assert.assertNotNull(newCompany);
		System.out.println(newCompany.getLastCritic().getAuthorComment().getText());
		System.out.println(newCompany.getLastCritic().getReplies().get(1).getText());
		Assert.assertEquals(newCompany.getLastCritic().getAuthorComment().getText() , "hola mundo");
		Assert.assertEquals(newCompany.getLastCritic().getReplies().get(1).getText() , "Que buena empresa!!");
    }
	
	
	
//	@Ignore
//	public void testPersistCompany2() {
//		String name = "Finnegans";
//		Industry industry = new Industry("IT");
//		Company company = new Company(name, industry);
//		Critic critic = new Critic(1200, company, new Comment("Comentario Lalala"));
//		ICompanyRepository rep = new CompanyRepository();
//		company.addCritic(critic);
//		company.addCritic(new Critic(111, company, new Comment("Jojojojo")));
//		company.addCritic(new Critic(222, company, new Comment("Jijijiji")));
//		rep.save(company);
//		Assert.assertTrue(company.getId() != 0);
//    }

}
