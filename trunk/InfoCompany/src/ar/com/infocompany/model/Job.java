/*
 * Job
 * 
 */

package ar.com.infocompany.model;

public class Job {

	private Industry industry;
	private String name;
	
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
	
}

// eof
