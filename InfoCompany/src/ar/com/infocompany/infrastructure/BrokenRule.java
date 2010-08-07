package ar.com.infocompany.infrastructure;

public class BrokenRule  
{ 
    private String relatesToProperty; 
    private String rule; 
	    
    public BrokenRule( String relatesToProperty, String rule ) 
    { 
        this.relatesToProperty = relatesToProperty; 
        this.rule = rule; 
    }

	public String getRule() {
		return rule;
	}

	public String getRelatesToProperty() {
		return relatesToProperty;
	} 
	
} 
    
    
 
