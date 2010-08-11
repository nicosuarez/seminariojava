/*
 * Industry
 * 
 */
package ar.com.infocompany.model;

import java.util.LinkedList;
import java.util.List;

import ar.com.infocompany.infraestructure.BusinessBase;
import ar.com.infocompany.infraestructure.IValueObject;

public class Industry extends BusinessBase implements IValueObject {
	
	private static List<Industry> instances = new LinkedList<Industry>();
	
	private String name;
	private List<Job> jobs;
		
	public static Industry getIndustry(String industryName) {
		Industry industry = null;
		synchronized(instances) {
			for (Industry i :  instances) {
				if (i.getName().equals(industryName)) {
					industry = i;
					break;
				}
			}
			if (industry == null) {
				industry = new Industry(industryName);
				instances.add(industry);
			}
		}
		return industry;
	}
		
	public Industry() {
		
	}
	
	private Industry(String industryName) {
		this.name = industryName;
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<Job> getJobs() {
		return jobs;
	}
	
	public boolean equals(Object o) {
		return (o instanceof Industry) && (this.name.equals(((Industry) o).name));
	}
	
	public int hashcode() {
		return this.name.hashCode();
	}
	
	protected void validate() {
		if (isVoid(this.name)) {
			this.addBrokenRule("Name", "El nombre de la industria es requerido.");
		}
	}
}

// eof
