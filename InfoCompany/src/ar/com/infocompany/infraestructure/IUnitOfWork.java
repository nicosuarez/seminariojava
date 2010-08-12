package ar.com.infocompany.infraestructure;

import ar.com.infocompany.infraestructure.exceptions.ConcurrencyException;

public interface IUnitOfWork {
	void save( IAggregateRoot entity );
	void commit() throws Exception, ConcurrencyException;
	void delete( IAggregateRoot entity );
}
