package ar.com.infocompany.model;

import java.util.List;

import ar.com.infocompany.infraestructure.exceptions.ApplicationException;

public interface IUserService {
	public void registerUser(User user) throws ApplicationException;
	public List<User> findAllUsers();
}