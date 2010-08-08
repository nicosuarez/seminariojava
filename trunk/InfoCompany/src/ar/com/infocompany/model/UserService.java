/*
 * UserService
 */
package ar.com.infocompany.model;

import ar.com.infocompany.infraestructure.query.Query;
import ar.com.infocompany.repository.hibernate.UserRepository;

public class UserService {

	public boolean registerUser(User user) {
		IUserRepository userRep = new UserRepository();
		Query  query = new Query(); 
		userRep.findBy(query);
		return true;
	}
	
}

// eof
