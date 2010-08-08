package ar.com.infocompany.repository.hibernate;

import ar.com.infocompany.infraestructure.query.Query;
import ar.com.infocompany.infraestructure.query.Criteria;

public class QueryTranslator {
	
	public static org.hibernate.Criteria getCriteriaFrom(org.hibernate.Criteria criteria, Query query) {
		for ( Criteria c : query.getCriteriaList()){
			switch (c.getOperator()){
				case Equals:
					criteria.add(org.hibernate.criterion.Expression.eq(c.getPropertyName(), c.getValue()));
					break;
				case Like:
					criteria.add(org.hibernate.criterion.Expression.eq(c.getPropertyName(), String.format("%s%", c.getValue())));
					break;
				default:
					System.out.println("The operator is unknown.");
					break;
			}
		}
		return criteria;
	}
}
