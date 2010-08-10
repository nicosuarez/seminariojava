/*
 * UserService
 */
package ar.com.infocompany.services;

import java.util.List;

import ar.com.infocompany.infraestructure.BrokenRule;
import ar.com.infocompany.infraestructure.custom_exceptions.ApplicationException;
import ar.com.infocompany.infraestructure.query.Criteria;
import ar.com.infocompany.infraestructure.query.CriteriaOperator;
import ar.com.infocompany.infraestructure.query.Query;
import ar.com.infocompany.model.IUserRepository;
import ar.com.infocompany.model.IUserService;
import ar.com.infocompany.model.User;
import ar.com.infocompany.repository.hibernate.UserRepository;

public class UserService implements IUserService {

	public void registerUser(User user) throws ApplicationException {
		List<BrokenRule> brokenRules = user.getBrokenRules();
		if (brokenRules.size() > 0) {
			throw new ApplicationException("Error en el registro de usuario", brokenRules);
		}
		IUserRepository userRep = new UserRepository();
		if (this.userExist(user)) {
			throw new ApplicationException("usuario registrado");
		} else {
			userRep.save(user);
		}
	}
	
	public boolean userExist(User user) {
		IUserRepository userRep = new UserRepository();
		Query  query = new Query();
		query.addCriteria(new Criteria(User.NAME, 
				user.getUserName(), CriteriaOperator.Equals));
		List<User> users = userRep.findBy(query);
		return (users.size() > 0); 
	}
	
}

// eof
