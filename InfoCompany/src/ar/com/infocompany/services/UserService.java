/*

 * UserService
 */
package ar.com.infocompany.services;

import java.util.List;

import ar.com.infocompany.infraestructure.BrokenRule;
import ar.com.infocompany.infraestructure.exceptions.ApplicationException;
import ar.com.infocompany.infraestructure.query.Criteria;
import ar.com.infocompany.infraestructure.query.CriteriaOperator;
import ar.com.infocompany.infraestructure.query.Query;
import ar.com.infocompany.model.IUserRepository;
import ar.com.infocompany.model.IUserService;
import ar.com.infocompany.model.User;
import ar.com.infocompany.repository.hibernate.UserRepository;

public class UserService implements IUserService {

	private IUserRepository userRep;
	
	public UserService() {
		userRep = new UserRepository();
	}
	
	public void registerUser(User user) throws ApplicationException {
		List<BrokenRule> brokenRules = user.getBrokenRules();
		if (brokenRules.size() > 0) {
			throw new ApplicationException("Error en el registro de usuario", brokenRules);
		}

		if (this.userExist(user)) {
			throw new ApplicationException("usuario registrado");
		} else {
			userRep.save(user);
		}
	}
	
	public void updateUser(User user) throws ApplicationException {
		List<BrokenRule> brokenRules = user.getBrokenRules();
		if (brokenRules.size() > 0) {
			throw new ApplicationException("Error en el registro de usuario", brokenRules);
		}	
		userRep.save(user);
	}
	
	public User authenticateUser(String userName, String password)
			throws ApplicationException {
		User user = this.getUser(userName);
		if ((user == null) || !(user.getPassword().equals(password))) {
			throw new ApplicationException();
		}
		return user;
	}
	
	public boolean userExist(User user) {
		
		Query  query = new Query();
		query.addCriteria(new Criteria(User.NAME, 
				user.getUserName(), CriteriaOperator.Equals));
		List<User> users = userRep.findBy(query);
		return (users.size() > 0); 
	}

	@Override
	public List<User> findAllUsers() {
		return userRep.findAll();
	}
	
	private User getUser(String userName) {
		Query  query = new Query();
		query.addCriteria(new Criteria(User.NAME, 
				userName, CriteriaOperator.Equals));
		List<User> users = userRep.findBy(query);
		
		return (users.size() > 0) ? users.get(0) : null; 
	}
	
}

// eof
