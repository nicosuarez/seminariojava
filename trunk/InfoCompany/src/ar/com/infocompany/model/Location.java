/*
 * Location
 * 
 */
package ar.com.infocompany.model;

public class Location {

	String country;
	String state;
	
	public Location(String country, String state) {
		if ((country == null) || (state == null)) {
			throw new IllegalArgumentException();
		}
		this.country = country;
		this.state = state;
	}
	
	public String getCountry() {
		return this.country;
	}
	
	public String getState() {
		return this.state;
	}
	
}

// eof
