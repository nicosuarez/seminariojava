package ar.com.infocompany.infrastructure;

import java.util.List;

public interface IRepository<T extends IAggregateRoot>  {
	void save (T entity);
	void remove (T entity);
	T findBy (int id);
	List<T> findAll(); 
}
