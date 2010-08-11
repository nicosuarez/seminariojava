/*
 * Job
 * 
 */

package ar.com.infocompany.model;

import java.util.LinkedList;
import java.util.List;

import ar.com.infocompany.infraestructure.BusinessBase;
import ar.com.infocompany.infraestructure.IValueObject;

public class Job extends BusinessBase implements IValueObject{
	
	private static List<Job> instances = new LinkedList<Job>();
	
	private String name;
	
	public static Job getJob(String jobName) {
		Job job = null;
		synchronized(instances) {
			for(Job j :  instances) {
				if (j.getName().equals(jobName)) {
					job = j;
					break;
				}
			}
			if (job == null) {
				job = new Job(jobName);
				instances.add(job);
			}
		}
		return job;
	}
	
	public Job() {
	
	}
	
	private Job(String jobName) {
		if (jobName == null) {
			throw new IllegalArgumentException();
		}
		this.name = jobName;
	}
	
	public String getName() {
		return this.name;
	}

	public boolean equals(Object o) {
		return (o instanceof Job) && (this.name.equals(((Job) o).name));
	}
	
	public int hashcode() {
		return this.name.hashCode();
	}
	
	protected void validate() {		
		if(this.isVoid(name)) {
			this.addBrokenRule("Name", "El nombre del trabajo es requerido.");
		}
	}
	
}

// eof
