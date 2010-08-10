/*
 * Job
 * 
 */

package ar.com.infocompany.model;

import java.util.LinkedList;
import java.util.List;

import ar.com.infocompany.infraestructure.BusinessBase;

public class Job extends BusinessBase {

	private Industry industry;
	private String name;
	
	private static List<Job> instances = new LinkedList<Job>();
	
	public static Job getJob(String industryName, String jobName) {
		Job job = null;
		Industry industry = Industry.getIndustry(industryName); 
			
		synchronized(instances) {
			for(Job j :  instances){
				if(j.getName().equals(jobName) && industry == j.getIndustry()){
					job = j;
					break;
				}
			}
			if(job == null){
				job = new Job(industry,jobName);
				instances.add(job);
			}
		}
		return job;
	}
	
	//Probar si se puede sacar 
	public Job() {
	
	}
	
	private Job(Industry industry, String jobName) {
		if ((industry == null) || (jobName == null)) {
			throw new IllegalArgumentException();
		}
		this.industry = industry;
		this.name = jobName;
	}
	
	public Industry getIndustry() {
		return this.industry;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	protected void validate() {
		if (this.industry == null) {
			this.addBrokenRule("Industry", "La industria del trabajo es requerida.");
		} else {
			this.addBrokenRule(this.industry.getBrokenRules());
		}
		
		if(this.isVoid(name)) {
			this.addBrokenRule("Name", "El nombre del trabajo es requerido.");
		}
	}
	
}

// eof
