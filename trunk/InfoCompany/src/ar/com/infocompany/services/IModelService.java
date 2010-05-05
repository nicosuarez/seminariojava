package ar.com.infocompany.services;

import java.util.List;

import ar.com.infocompany.entities.Company;
import ar.com.infocompany.entities.Field;
import ar.com.infocompany.entities.User;


public interface IModelService{
	
	public List<Company> getAllCompanies();
	public Company getCompany(Integer id);
	public void updateCompany(Company company);
	public void insertCompany(Company company);
	public void deleteCompany(Integer id);
	
	public List<Field> getAllFields();
	public Field getField(Integer id);
	public void updateField(Field field);
	public void insertField(Field field);
	public void deleteField(Integer id);
	
	public List<User> getAllUsers();
	public User getUser(Integer id);
	public void updateUser(User user);
	public void insertUser(User user);
	public void deleteUser(Integer id);
}
