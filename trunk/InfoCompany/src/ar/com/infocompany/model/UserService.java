/*
 * UserService
 */
package ar.com.infocompany.model;

import java.util.List;

import ar.com.infocompany.infraestructure.BrokenRule;
import ar.com.infocompany.infraestructure.custom_exceptions.ApplicationException;
import ar.com.infocompany.infraestructure.query.Criteria;
import ar.com.infocompany.infraestructure.query.CriteriaOperator;
import ar.com.infocompany.infraestructure.query.Query;
import ar.com.infocompany.repository.hibernate.UserRepository;

public class UserService {

	public void registerUser(User user) throws ApplicationException {
		List<BrokenRule> brokenRules = user.getBrokenRules();
		if (brokenRules.size() > 0) {
			throw new ApplicationException("", brokenRules);
		}
		IUserRepository userRep = new UserRepository();
		Query  query = new Query();
		query.addCriteria(new Criteria(User.NAME, 
				user.getUserName(), CriteriaOperator.Equals));
		List<User> users = userRep.findBy(query);
		if (users.size() > 0) {
			throw new ApplicationException("usuario registrado");
		} else {
			userRep.save(user);
		}
	}
	
}

// eof
