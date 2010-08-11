package ar.com.infocompany.infraestructure;

import java.util.List;

import ar.com.infocompany.infraestructure.query.Query;

public interface IValueObjectRepository<T extends IValueObject>  {
	T findBy (int id);
	List<T> findBy (Query query);
	List<T> findAll();
}
