package ar.com.infocompany.dao;

import java.util.List;

import ar.com.infocompany.entities.User;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserHibernateDAO implements IUserDAO{
	
	private User user;
	private List<User> users;
	
	public UserHibernateDAO() {
	}
	
	@SuppressWarnings("unchecked")
	public List<User> list() {
		Session session = HibernateUtil.getSession();
		
		try {
			session.beginTransaction();
			String hql = "from User";
			Query query = session.createQuery(hql);
			users =  query.list();
			return users;
		} catch (HibernateException e) {
			throw e;
		} finally {
			session.close();
		}
	}
	
	public User find(Integer id) {
		Session session = HibernateUtil.getSession();
		
		try{
			session.beginTransaction();
			Query q = session
						.createQuery("from User as e where e.UserId =:UserId");
			q.setInteger("UserId", id);
			return (User) q.uniqueResult();
			
		} finally {
			session.close();
		}
	}
	
	public void create(User user) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null) tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void update(User user) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx=session.beginTransaction();
			session.update(user);
			tx.commit();
		}catch (RuntimeException e) {
			if(tx != null) tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void delete(Integer id) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			user = (User)session.get(User.class, id);
			session.delete(user);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null) tx.rollback();
			throw e;
		} finally {
		    session.close();
		}
	}
	
	public User find(String userName) {
		Session session = HibernateUtil.getSession();
		
		try{
			session.beginTransaction();
			Query q = session
						.createQuery("from User as e where e.UserName =:UserName");
			q.setString("UserName", userName);
			return (User) q.uniqueResult();
			
		} finally {
			session.close();
		}
	}
	
}
