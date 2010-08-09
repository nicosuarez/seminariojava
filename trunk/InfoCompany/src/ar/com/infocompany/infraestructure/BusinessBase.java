package ar.com.infocompany.infraestructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ar.com.infocompany.infraestructure.IEntity;

public abstract class BusinessBase implements IEntity {
	
	private int id;
	private List<BrokenRule> brokenRules; 
//	private Class<T> persistentClass;
	
	public BusinessBase() {
//		 this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
//	                .getGenericSuperclass()).getActualTypeArguments()[0];
		 this.id = 0;
	}
	
//	public Class<T> getPersistentClass() {
//        return persistentClass;
//    }

	public int getId() {
		return id;
	}

	public boolean equals(Object obj) {
    	boolean equals = false;
        if (obj instanceof BusinessBase) {
        	BusinessBase entity = (BusinessBase) obj;
            if (entity.getId() == this.getId()) { 
                equals = true;
            }  
        } 
        return equals;
    } 
        
    public boolean isTransient() { 
        return (this.id == 0); 
    } 
    
    /*
    private boolean hasSameIdentifierAs( T entityToCompare ) { 
        if ( !( ( isTransient() & entityToCompare.isTransient() ) ) ) { 
            return this.id == entityToCompare.getId(); 
        } 
        else { 
            return false; 
        } 
    } 
    */
    public int hashCode() { 
        if ( isTransient() ) { 
            return this.getClass().getName().hashCode(); 
        } 
        else { 
            return String.format("%s%s", this.getClass().getName(), Integer.valueOf(id)).hashCode(); 
        } 
    } 
    
    /*
    private boolean hasDifferentPersistanceContextAs( T entityToCompare ) { 
        return !( ( isTransient() == entityToCompare.isTransient() ) ); 
    }
    */
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
    	return this.getBrokenRulesWritable().add(rule);
    }
    
    protected boolean addBrokenRule(String relatesToProperty , String rule) {
    	BrokenRule brokenRule = new BrokenRule(relatesToProperty, rule);
    	return this.addBrokenRule(brokenRule);
    }
    
    public List<BrokenRule> getBrokenRules() { 
        this.getBrokenRulesWritable().clear(); 
        this.validate(); 
        return Collections.unmodifiableList(this.brokenRules); 
    } 
    
    public boolean isVoid(String value) {
    	return (value.isEmpty() || (value == null));
    }
    
} 
