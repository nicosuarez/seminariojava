package ar.com.infocompany.model;

import java.util.List;

import ar.com.infocompany.infraestructure.exceptions.ApplicationException;

public interface IUserService {
	public void registerUser(User user) throws ApplicationException;
	public User authenticateUser(String userName, String password) throws ApplicationException;
	public List<User> findAllUsers();
	public void updateUser(User user) throws ApplicationException ;
}
