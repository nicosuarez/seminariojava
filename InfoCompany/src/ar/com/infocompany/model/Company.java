package ar.com.infocompany.model;

import java.util.Set;

import ar.com.infocompany.entities.Field;

public class Company {
	
	private int id;
	private String name;
	private Industry industry;
	private Set<Critic> critics;
	
	public Company(int id, String name, Field field) {
		
	}
	
	// getBestCritics(n)
	
	public int getRating() {
		int rating = 0;
		for (Critic critic : this.critics) {
			rating += (critic.getCompanyRating() * critic.getAuthor().getReputation());
		}
		rating = (rating / this.critics.size());
		return rating;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Industry getIndustry() {
		return this.industry;
	}

}

// eof
