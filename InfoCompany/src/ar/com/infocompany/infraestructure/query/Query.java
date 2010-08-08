package ar.com.infocompany.infraestructure.query;

import java.util.LinkedList;
import java.util.List;

public class Query {
	
	private List<Criteria> criteriaList;
	
	public Query() {
		this.setCriteria(new LinkedList<Criteria>());
	}
	
	public Query(List<Criteria> criteriaList) {
		this.criteriaList = criteriaList; 
	}
	
	public boolean addCriteria(Criteria criteria) {
		return this.criteriaList.add(criteria);
	}
	
	public void setCriteria(List<Criteria> criteriaList) {
		this.criteriaList = criteriaList;
	}
	
	public List<Criteria> getCriteriaList() {
		return this.criteriaList;
	}
	
}
