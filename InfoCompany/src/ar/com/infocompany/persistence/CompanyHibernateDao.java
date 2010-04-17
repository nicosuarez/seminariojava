package ar.com.infocompany.persistence;

import java.util.List;

import ar.com.infocompany.entities.Company;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CompanyHibernateDao implements CompanyDao{
	
	private Company company;
	private List<Company> companies;
	
	public CompanyHibernateDao() {
	}
	
	public List<Company> getAllCompanies() {
		Session session = HibernateUtil.getSession();
		
		try {
			session.beginTransaction();
			String hql = "from Company";
			Query query = session.createQuery(hql);
			companies = query.list();
			return companies;
		} catch (HibernateException e) {
			throw e;
		} finally {
			session.close();
		}
	}
	
	public Company getCompany(Integer id) {
		Session session = HibernateUtil.getSession();
		
		try{
			session.beginTransaction();
			Query q = session
						.createQuery("from Company as e where e.CompanyId =:CompanyId");
			q.setInteger("CompanyId", id);
			return (Company) q.uniqueResult();
			
		} finally {
			session.close();
		}
	}
	
	public void insertCompany(Company company) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(company);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null) tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void updateCompany(Company company) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx=session.beginTransaction();
			session.update(company);
			tx.commit();
		}catch (RuntimeException e) {
			if(tx != null) tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void deleteCompany(Integer id) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			company = (Company)session.get(Company.class, id);
			session.delete(company);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null) tx.rollback();
			throw e;
		} finally {
		    session.close();
		}
	}
	
}
