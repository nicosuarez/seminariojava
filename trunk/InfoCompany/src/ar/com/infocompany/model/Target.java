/*
 * Target
 * 
 */
package ar.com.infocompany.model;

public class Target {
	
	private Company company;
	private Job job;

	public Target(Company company, Job job) {
		this.company = company;
		this.job = job;
	}
	
	public Company getCompany() {
		return this.company;
	}
	
	public Job getJob() {
		return this.job;
	}
	
}

// eof
