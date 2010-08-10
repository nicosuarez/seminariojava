package ar.com.infocompany.model;

import java.util.LinkedList;
import java.util.List;

import ar.com.infocompany.infraestructure.BusinessBase;
import ar.com.infocompany.infraestructure.IAggregateRoot;

public class Industry extends BusinessBase implements IAggregateRoot {
	
	private String name;
	private static List<Industry> instances = new LinkedList<Industry>();
	
	public static Industry getIndustry(String industryName) {
		Industry industry = null;
		synchronized(instances) {
			for(Industry i :  instances){
				if(i.getName().equals(industryName)){
					industry = i;
					break;
				}
			}
			if(industry == null){
				industry = new Industry(industryName);
				instances.add(industry);
			}
		}
		return industry;
	}
	
	//Probar si se puede sacar
	public Industry() {
		
	}
	
	private Industry(String name) {
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
