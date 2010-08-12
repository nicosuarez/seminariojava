package ar.com.infocompany.presentation;

import ar.com.infocompany.model.User;



/*
 * Simple interface for actions that want have the user object injected.  
 */

public interface UserAware {
	
	public void setUser( User user );
	
}