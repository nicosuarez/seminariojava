package ar.com.infocompany.model;

import java.util.LinkedList;
import java.util.List;

import ar.com.infocompany.infraestructure.BusinessBase;
import ar.com.infocompany.infraestructure.IValueObject;

public class Industry extends BusinessBase implements IValueObject {
	
	private String name;
	private List<Job> jobs;
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
		
	public Industry() {
		
	}
	
	public Industry(String industryName){
		this.name = industryName;
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<Job> getJobs() {
		return jobs;
	}
	
	@Override
	protected void validate() {
		if (isVoid(name)) {
			this.addBrokenRule("Name", "El nombre de la industria es requerido.");
		}
	}
}

// eof
