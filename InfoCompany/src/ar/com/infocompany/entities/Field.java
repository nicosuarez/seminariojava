package ar.com.infocompany.entities;

import java.io.Serializable;

public class Field implements Serializable{
	
	private static final long serialVersionUID = 6147278629729650634L;
	private Integer fieldId;
	private String description;
	
	public Field() {}

	public Field(String description)
	{
		this.description = description;
	}
	
	public Field(Integer fieldId, String description)
	{
		this.fieldId = fieldId;
		this.description = description;
	}
	
	public Integer getFieldId() {
		return fieldId;
	}
	
	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}	
}
