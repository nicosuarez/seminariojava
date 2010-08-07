package ar.com.infocompany.infrastructure;

import ar.com.infocompany.infraestructure.custom_exceptions.ConcurrencyException;

public interface IUnitOfWork {
	void save( IAggregateRoot entity );
	void commit() throws Exception, ConcurrencyException;
	void delete( IAggregateRoot entity );
}
