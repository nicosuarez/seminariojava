package ar.com.infocompany.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ar.com.infocompany.entities.Field;

public class FieldHibernateDAO implements IFieldDAO{
	
	private List<Field> fields;
	private Field field;
	
	public FieldHibernateDAO()
	{
		
	}
	
	public List<Field> getAllFields()
	{
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			String hql = "from Field";
			Query query = session.createQuery(hql);
			fields = query.list();
			return fields;
		} catch (HibernateException e) {
			throw e;
		} finally {
			session.close();
		}
	}
	
	public Field getField(Integer id)
	{
		Session session = HibernateUtil.getSession();
		try{
			session.beginTransaction();
			Query q = session.createQuery("from Field as e where e.FieldId =:FieldId");
			q.setInteger("FieldId", id);
			return (Field) q.uniqueResult();
		} finally {
			session.close();
		}
	}
	
	public void updateField(Field field)
	{
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx=session.beginTransaction();
			session.update(field);
			tx.commit();
		}catch (RuntimeException e) {
			if(tx != null) tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void insertField(Field field)
	{
		Session session = HibernateUtil.getSession();
		Transaction tx = null;		
		try {
			tx = session.beginTransaction();
			session.save(field);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null) tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void deleteField(Integer id)
	{
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			field = (Field)session.get(Field.class, id);
			session.delete(field);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null) tx.rollback();
			throw e;
		} finally {
		    session.close();
		}
	}


}
