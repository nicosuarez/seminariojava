package ar.com.infocompany.dao;

import java.util.List;

import ar.com.infocompany.entities.Field;

public interface IFieldDAO 
{
	public List<Field> getAllFields();
	public Field getField(Integer id);
	public void updateField(Field field);
	public void insertField(Field field);
	public void deleteField(Integer id);

}
