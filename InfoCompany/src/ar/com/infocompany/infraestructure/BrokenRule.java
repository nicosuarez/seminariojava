package ar.com.infocompany.infraestructure;

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
    
    
 
