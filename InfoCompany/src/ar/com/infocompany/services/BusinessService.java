package ar.com.infocompany.services;

import ar.com.infocompany.entities.User;

public class BusinessService implements IBusinessService{

	private ModelService modelService;
	
	/* 
	 * Returns a user object if the userName and password are valid.  Returns null otherwise.
	 */
	public User authenticateUser(String userName, String password) {
		
		System.out.println("Authenticating: username = " + userName );
	
		/* 
		 * Retrieve a user object.
		 * We're building a copy so that it mirrors the behavior of the persistence backed object.
		 */
		User persistedUser = (User) this.getModelService().getUser( userName );
		User userModel = null;
		
		/* If the userName mapped to a real user, check password */
		if ( persistedUser != null && persistedUser.getPassword().equals( password )) {
			
			//create User object to return for the application to use 
//			userModel = getModelCopy ( persistedUser );
			userModel = persistedUser;
		}
	
		return userModel;
	}

	public ModelService getModelService() {
		return modelService;
	}

	public void setModelService(ModelService modelService) {
		this.modelService = modelService;
	}
	
	
	
}
