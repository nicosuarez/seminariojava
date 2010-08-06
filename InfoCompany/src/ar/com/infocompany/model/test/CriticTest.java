package ar.com.infocompany.model.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import ar.com.infocompany.model.Comment;
import ar.com.infocompany.model.Company;
import ar.com.infocompany.model.Critic;
import ar.com.infocompany.model.ICriticRepository;
import ar.com.infocompany.model.Industry;
import ar.com.infocompany.repository.hibernate.CriticRepository;

public class CriticTest {

	@Before
	public void dhdhd() {
		System.out.println("exec before");
	}
	
	@Test
	public void testPersistCritic() {
		Critic critic = new Critic( 100, new Company("Coto", new Industry("IT")), new Comment("LALALALALALA") );
		ICriticRepository rep = new CriticRepository();
		rep.save(critic);
		Assert.assertTrue(critic.getId() != 0);
    }
	
}
