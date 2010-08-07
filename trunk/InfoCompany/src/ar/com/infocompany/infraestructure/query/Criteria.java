package ar.com.infocompany.infraestructure.query;

public class Criteria {
	private String propertyName;
	private Object value;
	private CriteriaOperator operator;
	
	public Criteria( String propertyName, Object value, CriteriaOperator operator){
		this.operator=operator;
		this.value=value;
		this.propertyName=propertyName;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setProperty(String property) {
		this.propertyName = property;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public CriteriaOperator getOperator() {
		return operator;
	}

	public void setOperator(CriteriaOperator operator) {
		this.operator = operator;
	}
	
}
