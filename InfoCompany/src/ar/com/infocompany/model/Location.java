/*
 * Location
 * 
 */
package ar.com.infocompany.model;

import ar.com.infocompany.infraestructure.custom_exceptions.InvalidLocationException;

public class Location {

	String country;
	String state;
	
	public Location(){
		
	}
	
	public Location(String country, String state) throws InvalidLocationException {
		this.country = country;
		this.state = state;
		
		validate();
	}
	
	protected void validate() throws InvalidLocationException {
		
		StringBuilder sbBrokenRules = new StringBuilder();
		
		if (isNullOrEmpty(country.trim())) {
			sbBrokenRules.append("El pais es requerido.");
		}
		else {
			if(country.length() > 50) {
				sbBrokenRules.append("El pais debe tener 50 caracteres o menos");
			}
		}
			
		if(isNullOrEmpty(state)) {
			sbBrokenRules.append("El estado/provincia es requerido.");
		}else {
			if(state.length() > 50) {
				sbBrokenRules.append("El estado/provincia debe tener 50 caracteres o menos");
			}
		}
			
		if(!(isNullOrEmpty(sbBrokenRules.toString()))) {
			String errorMessage = "Error de reglas en Ubicacion, porfavor verifique los siguientes errores: ";
			
			throw new InvalidLocationException(String.format("%s%s%s",errorMessage,"\n",sbBrokenRules.toString()));
		}
	}

	public String getCountry() {
		return this.country;
	}
	
	public String getState() {
		return this.state;
	}
	
	protected boolean isNullOrEmpty(String value) {
    	return (value.isEmpty() || (value == null));
    }
	
}

// eof
