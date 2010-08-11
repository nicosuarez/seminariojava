package ar.com.infocompany.model;

import java.util.List;

import ar.com.infocompany.infraestructure.BusinessBase;
import ar.com.infocompany.infraestructure.IValueObject;

public class Country extends BusinessBase implements IValueObject{
	
	private String name;
	private List<State> states;
	
	public Country(){
		
	}
	
	public String getName() {
		return this.name;
	}

	public List<State> getStates() {
		return this.states;
	}
	
	@Override
	protected void validate() {
		if (isVoid(name)) {
			this.addBrokenRule("Name", "El nombre del pais es requerido.");
		}
	}

}
