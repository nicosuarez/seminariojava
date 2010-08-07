package ar.com.infocompany.model;

import ar.com.infocompany.infrastructure.BusinessBase;
import ar.com.infocompany.infrastructure.IAggregateRoot;

public class Industry extends BusinessBase<Industry> implements IAggregateRoot {
	
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
		if(isNullOrEmpty(name)) {
			this.addBrokenRule("Name", "El nombre de la industria es requerido.");
		}
	}

}

// eof
