package ar.com.infocompany.model;

import ar.com.infocompany.infraestructure.custom_exceptions.ApplicationException;

public interface IUserService {
	public void registerUser(User user) throws ApplicationException;
}
