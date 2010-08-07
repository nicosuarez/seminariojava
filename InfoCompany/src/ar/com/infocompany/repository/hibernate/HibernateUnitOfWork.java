package ar.com.infocompany.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.StaleObjectStateException;
import org.hibernate.Transaction;

import ar.com.infocompany.infraestructure.custom_exceptions.ConcurrencyException;
import ar.com.infocompany.infrastructure.IAggregateRoot;
import ar.com.infocompany.infrastructure.IUnitOfWork;

public class HibernateUnitOfWork implements IUnitOfWork {

	private Session session;
	
	public HibernateUnitOfWork() {
		this.session = SessionFactory.getCurrentSession();
	}

	@Override
	public void save(IAggregateRoot entity) {
		session.saveOrUpdate(entity);
	}

	
	@Override
	public void commit() throws Exception, ConcurrencyException {
		Transaction tx = this.session.beginTransaction();
		
		try {
			//Flush the session and commit the transaction.
			tx.commit();
		}
		catch(StaleObjectStateException hex) {
			tx.rollback();
			throw new ConcurrencyException("Por favor actualice la pantalla, se han producido cambios a una entidad desde que se mostro");
		}
		catch(Exception ex){
			tx.rollback();
			//TODO: ADD LOG
			System.out.println(ex.getMessage());
			throw ex;
		}

	}
	
	@Override
	public void delete( IAggregateRoot entity ) {
		this.session.delete(entity);
	}

}
