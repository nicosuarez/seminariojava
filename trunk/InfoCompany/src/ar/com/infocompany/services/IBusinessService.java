package ar.com.infocompany.services;

import ar.com.infocompany.entities.User;

public interface IBusinessService {

	public User authenticateUser(String userName, String password);
	
}
