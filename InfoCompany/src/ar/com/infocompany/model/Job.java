/*
 * Job
 * 
 */

package ar.com.infocompany.model;

import ar.com.infocompany.infraestructure.BusinessBase;

public class Job extends BusinessBase<Comment> {

	private Industry industry;
	private String name;
	
	public Job() {
	
	}
	
	public Job(Industry industry, String jobName) {
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
