package ar.com.infocompany.dao;

import java.util.List;

import ar.com.infocompany.entities.Company;

public interface IBaseEntityDAO<T> {
	
	public List<T> list();
	public T find(Integer id);
	public void update(T entity);
	public void create(T entity);
	public void delete(Integer id);

}
