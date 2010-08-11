/*
 * CriticItem
 */
package ar.com.infocompany.model;

import ar.com.infocompany.infraestructure.BusinessBase;
import ar.com.infocompany.infraestructure.IValueObject;

public class CriticItem extends BusinessBase implements IValueObject{
	
	String tag;
	int score;
	
	public CriticItem(){
		
	}
	
	public CriticItem(String tag, int score) {
		this.tag = tag;
		this.score = score;
	}
	
	public String getTag() {
		return this.tag;
	}
		
	public int getScore() {
		return this.score;
	}

	public boolean equals(Object o) {
		boolean equals = true;
		if (o instanceof CriticItem) {
			CriticItem item = (CriticItem) o;
			if ((this.tag.equals(item.tag)) && (this.score == item.score)) {
				equals = true;
			}
		}
		return equals;
	}
	
	public int hashcode() {
		return (this.tag + this.score).hashCode();
	}
	
	
	protected void validate() {
		if (this.isVoid(this.tag)) {
			this.addBrokenRule("Tag", "El tag del item es requerido.");
		}
		
		if(this.score < 0 && this.score > 10) {
			this.addBrokenRule("Score", "El puntaje debe ser un valor entre 0-10");
		}	
	}
	
}

// eof
