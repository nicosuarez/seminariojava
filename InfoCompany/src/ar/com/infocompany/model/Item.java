/*
 * Score
 * 
 */
package ar.com.infocompany.model;

import ar.com.infocompany.infraestructure.BusinessBase;

public class Item extends BusinessBase<Item> {
	
	String tag;
	int score;
	
	public Item(){
		
	}
	
	public Item(String tag, int score) {
		this.tag = tag;
		this.score = score;
	}
	
	public String getTag() {
		return this.tag;
	}
		
	public int getScore() {
		return this.score;
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
