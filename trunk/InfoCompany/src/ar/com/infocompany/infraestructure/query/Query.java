package ar.com.infocompany.infraestructure.query;

import java.util.ArrayList;
import java.util.List;

public class Query {
	private List<Criteria> criteria;
	
	public Query(){
		this.setCriteria(new ArrayList<Criteria>());
	}

	public void setCriteria(List<Criteria> criteria) {
		this.criteria = criteria;
	}

	public List<Criteria> getCriteria() {
		return criteria;
	}
}
