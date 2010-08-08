package ar.com.infocompany.infraestructure;

import java.util.List;

import ar.com.infocompany.infraestructure.query.Query;

public interface IRepository<T extends IAggregateRoot>  {
	void save (T entity);
	void remove (T entity);
	T findBy (int id);
	List<T> findBy (Query query);
	List<T> findAll();
	void inyect(IUnitOfWork unitOfWork);
}
