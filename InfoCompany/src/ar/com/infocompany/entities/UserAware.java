package ar.com.infocompany.entities;



/*
 * Simple interface for actions that want have the user object injected.  
 */

public interface UserAware {
	
	public void setUser( User user );
	
}