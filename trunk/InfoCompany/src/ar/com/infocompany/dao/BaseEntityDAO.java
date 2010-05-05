package ar.com.infocompany.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BaseEntityDAO<T> {
	
//	public T find(Integer id);
//	public void update(T entity);
//	public void create(T entity);
//	public void deleteCompany(T entity);
//	
//	private T entity;
//	private List<T> listEntities;
//			
//	public List<T> list() {
//		Session session = HibernateUtil.getSession();
//		
//		try {
//			session.beginTransaction();
//			String hql = "from Company";
//			Query query = session.createQuery(hql);
//			companies = query.list();
//			return companies;
//		} catch (HibernateException e) {
//			throw e;
//		} finally {
//			session.close();
//		}
//	}
//	
//	public T getCompany(Integer id) {
//		Session session = HibernateUtil.getSession();
//		
//		try{
//			session.beginTransaction();
//			Query q = session
//						.createQuery("from Company as e where e.CompanyId =:CompanyId");
//			q.setInteger("CompanyId", id);
//			return (T) q.uniqueResult();
//			
//		} finally {
//			session.close();
//		}
//	}
//	
//	public void insertCompany(Company company) {
//		Session session = HibernateUtil.getSession();
//		Transaction tx = null;
//		
//		try {
//			tx = session.beginTransaction();
//			session.save(company);
//			tx.commit();
//		} catch (RuntimeException e) {
//			if(tx != null) tx.rollback();
//			throw e;
//		} finally {
//			session.close();
//		}
//	}
//	
//	public void updateCompany(Company company) {
//		Session session = HibernateUtil.getSession();
//		Transaction tx = null;
//		try {
//			tx=session.beginTransaction();
//			session.update(company);
//			tx.commit();
//		}catch (RuntimeException e) {
//			if(tx != null) tx.rollback();
//			throw e;
//		} finally {
//			session.close();
//		}
//	}
//	
//	public void deleteCompany(Integer id) {
//		Session session = HibernateUtil.getSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			company = (Company)session.get(Company.class, id);
//			session.delete(company);
//			tx.commit();
//		} catch (RuntimeException e) {
//			if(tx != null) tx.rollback();
//			throw e;
//		} finally {
//		    session.close();
//		}
//	}	
}
