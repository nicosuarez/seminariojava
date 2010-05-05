package ar.com.infocompany.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 * This class represents a user of the InfoCompany system.  This is one of 
 * our applications main domain objects.
 */

public class User {
	
	private Integer userId;
	private String userName;
	private String password;
	private Date creationDate;
	private String firstName;
	private String lastName;
	private String email;
	
	private Map ratings = new HashMap();

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
			this.userName = userName;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Map getRatings()
	{
		return ratings;
	}
	public void setRatings( Map ratings ) {
		this.ratings = ratings;
	}

}
