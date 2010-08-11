package ar.com.infocompany.repository.hibernate;

import java.lang.reflect.ParameterizedType;
import java.util.List;


import ar.com.infocompany.infraestructure.IValueObject;
import ar.com.infocompany.infraestructure.IValueObjectRepository;
import ar.com.infocompany.infraestructure.query.Query;

import org.hibernate.Transaction;

public class BaseValueObjectRepository<T extends IValueObject > implements IValueObjectRepository<T> {

	private Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public BaseValueObjectRepository()
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
}
