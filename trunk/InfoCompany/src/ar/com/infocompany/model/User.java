/*
 * User
 * 
 */
package ar.com.infocompany.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ar.com.infocompany.infrastructure.BusinessBase;
import ar.com.infocompany.infrastructure.IAggregateRoot;

public class User extends BusinessBase<User> implements IAggregateRoot{
	
	private String userName;
	private String password;
	private String email;
	private Job job;
	private Location location;
	private int reputation;
	private List<Comment> comments;
	private List<Critic> critics;
	private int birthdayYear;
	private Date creationDate;
	
	public User() {
		 
	}
	
	public User(String userName, String password,
			String email, Job job, Location location, int birthdayYear) {
		this.email = email;
		this.setUserName(userName);
		this.password = password;
		this.job = job;
		this.location = location;
		this.setBirthdayYear(birthdayYear);
	}
	
	public Critic makeCritic() {
		return null;
	}
	
	public boolean isActive() {
		return true;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
		
	public Job getJob() {
		return this.job;
	}
	
	public int getReputation() {
		return this.reputation;
	}
	
	public int increaseReputation() {
		return ++this.reputation;
	}
	
	public int decreaseReputation() {
		return --this.reputation;
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}

	private void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setCritics(List<Critic> critics) {
		this.critics = critics;
	}

	public List<Critic> getCritics() {
		return critics;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setBirthdayYear(int birthdayYear) {
		this.birthdayYear = birthdayYear;
	}

	public int getBirthdayYear() {
		return birthdayYear;
	}

	@Override
	protected void validate() {
	
     	if(isNullOrEmpty(password.trim())) {
			this.addBrokenRule("Password", "El password es requerido.");
		}
		else {
			if(password.length() > 20) {
				this.addBrokenRule("Password", "El password debe tener como maximo 20 caracteres.");
			}
		}
     
     	if(isNullOrEmpty(email.trim())) {
			this.addBrokenRule("Email", "El email es requerido.");
		}
		else {
			if(userName.length() > 10) {
				this.addBrokenRule("Email", "El email debe tener como maximo 30 caracteres.");
			}
			
			Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		    Matcher m = p.matcher(email);
	        boolean matchFound = m.matches();
			if (!matchFound) {
			  this.addBrokenRule("Email", "El email tiene formato invalido.");
			}
		}
     
		if(isNullOrEmpty(userName.trim())) {
			this.addBrokenRule("UserName", "El nombre de usuario es requerido.");
		}
		else {
			if(userName.length() > 10) {
				this.addBrokenRule("UserName", "El nombre de usuario debe tener como maximo 10 caracteres.");
			}
		}
				
		if(this.job == null) {
			this.addBrokenRule("Job", "El trabajo actual del usuario es requerido.");
		}else {
			this.addBrokenRule(this.job.getBrokenRules());
		}
		
		if(this.birthdayYear >= 1900 && this.birthdayYear < Calendar.getInstance().get(Calendar.YEAR) - 10) {
			this.addBrokenRule("BirthdayYear", "El año de nacimiento es invalido.");
		}	
		
		if(this.critics != null) {
			for (Critic critic : this.critics) {
				this.addBrokenRule(critic.getBrokenRules());
			}
		}
		
		if(this.comments != null) {
			for (Comment comment : this.comments) {
				this.addBrokenRule(comment.getBrokenRules());
			}
		}
	}
	
}

// eof
