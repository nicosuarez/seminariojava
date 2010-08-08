package ar.com.infocompany.model;

import ar.com.infocompany.infraestructure.BusinessBase;
import ar.com.infocompany.infraestructure.IAggregateRoot;

public class Industry extends BusinessBase implements IAggregateRoot {
	
	private String name;
	
	public Industry() {
		
	}
	
	public Industry(String name) {
		this.name = name;
	}
		
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected void validate() {
		if (isVoid(name)) {
			this.addBrokenRule("Name", "El nombre de la industria es requerido.");
		}
	}

}

// eof
