/*
 * Item
 */

package ar.com.infocompany.model;

import ar.com.infocompany.infraestructure.BusinessBase;
import ar.com.infocompany.infraestructure.IValueObject;

public class Item extends BusinessBase implements IValueObject{
	
	private String name;
	
	public Item() {
	
	}
	
	public String getName() {
		return this.name;
	}

	public boolean equals(Object o) {
		return (o instanceof Item) && (this.name.equals(((Item) o).name));
	}
	
	public int hashcode() {
		return this.name.hashCode();
	}
	
	protected void validate() {		
		if(this.isVoid(name)) {
			this.addBrokenRule("Name", "El nombre del item es requerido.");
		}
	}
	
}

// eof
