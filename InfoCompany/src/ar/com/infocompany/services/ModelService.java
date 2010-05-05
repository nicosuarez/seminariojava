package ar.com.infocompany.services;


import java.util.List;

import ar.com.infocompany.dao.ICompanyDAO;
import ar.com.infocompany.dao.IFieldDAO;
import ar.com.infocompany.dao.IUserDAO;
import ar.com.infocompany.entities.Company;
import ar.com.infocompany.entities.Field;
import ar.com.infocompany.entities.User;


public class ModelService implements IModelService{
	
	private ICompanyDAO companyDAO;
	private IFieldDAO fieldDAO;
	private IUserDAO userDAO;
	
	public ModelService() {

	}

	//Company Service Entity
	
	public ICompanyDAO getCompanyDAO() {
		return companyDAO;
	}

	public void setCompanyDAO(ICompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}

	public List<Company> getAllCompanies() {
		return companyDAO.getAllCompanies();
	}
	
	public void deleteCompany(Integer id) {
		companyDAO.deleteCompany(id);
	}
	
	public Company getCompany(Integer id) {
		return companyDAO.getCompany(id);
	}
	
	public void insertCompany(Company company) {
		companyDAO.insertCompany(company);
	}
	
	public void updateCompany(Company company) {
		companyDAO.updateCompany(company);
	}

	//Field Service Entity
	
	public IFieldDAO getFieldDAO() {
		return fieldDAO;
	}

	public void setFieldDAO(IFieldDAO fieldDAO) {
		this.fieldDAO = fieldDAO;
	}
	
	public List<Field> getAllFields()
	{
		return fieldDAO.getAllFields();
	}
	
	public Field getField(Integer id)
	{
		return fieldDAO.getField(id);
	}
	
	public void updateField(Field field)
	{
		fieldDAO.updateField(field);
	}
	
	public void insertField(Field field)
	{
		fieldDAO.insertField(field);
	}
	
	public void deleteField(Integer id)
	{
		fieldDAO.deleteField(id);
	}
	
	//User Service Entity
	
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public List<User> getAllUsers()
	{
		return userDAO.list();
	}
	
	public User getUser(Integer id)
	{
		return userDAO.find(id);
	}
	
	public void updateUser(User user)
	{
		userDAO.update(user);
	}
	
	public void insertUser(User user)
	{
		userDAO.create(user);
	}
	
	public void deleteUser(Integer id)
	{
		userDAO.delete(id);
	}
	
	public User getUser(String userName)
	{
		return userDAO.find(userName);
	}
	
}
