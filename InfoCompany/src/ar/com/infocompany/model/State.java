package ar.com.infocompany.model;

import ar.com.infocompany.infraestructure.BusinessBase;
import ar.com.infocompany.infraestructure.IValueObject;

public class State extends BusinessBase implements IValueObject{

	private String name;
	
	public State() {
		
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	protected void validate() {
		if (isVoid(name)) {
			this.addBrokenRule("Name", "El nombre de la provincia es requerido.");
		}
	}

}
