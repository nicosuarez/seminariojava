package ar.com.infocompany.infrastructure;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ar.com.infocompany.infrastructure.IEntity;

public abstract class BusinessBase <T extends IEntity> implements IEntity 
{ 
	private Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public BusinessBase()
	{
		 this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
	                .getGenericSuperclass()).getActualTypeArguments()[0];
		 this.id = 0;
	}
	
	public Class<T> getPersistentClass() {
        return persistentClass;
    }

	private List<BrokenRule> brokenRules; 
    private int id; 
	

	public int getId() {
		return id;
	}

	//Equality Overrides
	
    @SuppressWarnings("unchecked")
	public boolean equals( Object obj ) { 
        if ( !( obj == null ) && obj.getClass() == persistentClass ) { 
            
            if ( this.hasSameIdentifierAs( ( ( T )( obj ) ) ) ) { 
                //  Both entities are persistant so we are able to 
                //  compare the identifiers
                return true; 
            } 
            else if ( hasDifferentPersistanceContextAs( ( ( T )( obj ) ) ) ) { 
                //  One entity is transient one is persistant so that cannot
                //  be eqaul
                return false; 
            } 
            else { 
                //  Neither Entity has an Identity
                return false; 
            } 
        } 
        return false;
    } 
        
    public boolean isTransient() { 
        return this.id == 0; 
    } 
    
    private boolean hasSameIdentifierAs( T entityToCompare ) { 
        if ( !( ( isTransient() & entityToCompare.isTransient() ) ) ) { 
            return this.id == entityToCompare.getId(); 
        } 
        else { 
            return false; 
        } 
    } 
    
    public int hashCode() { 
        if ( isTransient() ) { 
            return this.getClass().getName().hashCode(); 
        } 
        else { 
            return String.format("%s%s", this.getClass().getName(), Integer.valueOf(id)).hashCode(); 
        } 
    } 
    
    private boolean hasDifferentPersistanceContextAs( T entityToCompare ) { 
        return !( ( isTransient() == entityToCompare.isTransient() ) ); 
    } 
    
    //Entity Validation 
    
    protected abstract void validate();
    
    protected List<BrokenRule> getBrokenRulesWritable() { 
        if(this.brokenRules == null) {
            this.brokenRules = new ArrayList<BrokenRule>();
        } 
        return this.brokenRules;  
    } 
    
    protected void addBrokenRule(List<BrokenRule> rules) {
    	if(rules != null) {
			for (BrokenRule br : rules) {
				this.addBrokenRule(br);
			}
    	}
    }
    
    protected boolean addBrokenRule(BrokenRule rule) {
    	return this.getBrokenRules().add(rule);
    }
    
    protected boolean addBrokenRule(String relatesToProperty , String rule) {
    	BrokenRule brokenRule = new BrokenRule(relatesToProperty, rule);
    	return this.addBrokenRule(brokenRule);
    }
    
    public List<BrokenRule> getBrokenRules() { 
        this.brokenRules.clear(); 
        this.validate(); 
        return Collections.unmodifiableList(this.brokenRules); 
    } 
    
    public boolean isNullOrEmpty(String value) {
    	return (value.isEmpty() || (value == null));
    }
    
} 
