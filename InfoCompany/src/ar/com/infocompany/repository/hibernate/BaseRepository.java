package ar.com.infocompany.repository.hibernate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import ar.com.infocompany.infraestructure.query.Query;
import ar.com.infocompany.infrastructure.IAggregateRoot;
import ar.com.infocompany.infrastructure.IRepository;
import ar.com.infocompany.infrastructure.IUnitOfWork;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

public class BaseRepository<T extends IAggregateRoot > implements IRepository<T> {

	private Class<T> persistentClass;
	private IUnitOfWork unitOfWotk;
	
	@SuppressWarnings("unchecked")
	public BaseRepository()
	{
		 this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
	                .getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public Class<T> getPersistentClass() {
        return persistentClass;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		//TODO ver porque es necesario abrir la transaccion aca.??
		Transaction transaction = SessionFactory.getCurrentSession().beginTransaction();
		org.hibernate.Criteria criteriaQuery = SessionFactory.getCurrentSession().createCriteria(persistentClass);
		return criteriaQuery.list();   
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public T findBy(int id) {
		Transaction transaction = SessionFactory.getCurrentSession().beginTransaction();
		return (T) SessionFactory.getCurrentSession().get(getPersistentClass(),id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findBy(Query query) {
		Transaction transaction = SessionFactory.getCurrentSession().beginTransaction();
		org.hibernate.Criteria criteria = SessionFactory.getCurrentSession().createCriteria(getPersistentClass());
		return QueryTranslator.getCriteriaFrom(criteria, query).list();
	}
	
	@Override
	public void remove(T entity) {
		if(this.unitOfWotk == null) {
			Transaction transaction = SessionFactory.getCurrentSession().beginTransaction();
			SessionFactory.getCurrentSession().delete(entity);
			try 
			{
				transaction.commit();	
			} 
			catch (HibernateException hex) {
				transaction.rollback();
				//TODO: Log exception.
				throw hex;
			}
		}else {
			this.unitOfWotk.delete(entity);
		}
	}

	@Override
	public void save(T entity) {
		if(this.unitOfWotk == null) {
			Transaction transaction = SessionFactory.getCurrentSession().beginTransaction();
			SessionFactory.getCurrentSession().saveOrUpdate(entity);
			try 
			{
				transaction.commit();	
			} 
			catch (HibernateException hex) {
				transaction.rollback();
				//TODO: Log exception.
				throw hex;
			}
		}else {
			this.unitOfWotk.delete(entity);
		}
	}

	@Override
	public void inyect(IUnitOfWork unitOfWork) {
		this.unitOfWotk = unitOfWork;
		
	}

}
