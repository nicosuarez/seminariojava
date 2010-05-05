package ar.com.infocompany.dao;

import ar.com.infocompany.entities.User;

public interface IUserDAO extends IBaseEntityDAO<User>
{
	public User find(String userName);
}
