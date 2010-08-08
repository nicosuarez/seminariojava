/*
 * User
 * 
 */
package ar.com.infocompany.model;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ar.com.infocompany.infraestructure.BusinessBase;
import ar.com.infocompany.infraestructure.IAggregateRoot;

public class User extends BusinessBase implements IAggregateRoot{
	
	public static final String NAME = "userName";
		
	private String userName;
	private String password;
	private String email;
	private int birthdayYear;
	private Job job;
	private Location location;
	private int reputation;
	
	public User() {
		// Hibernate requirement
	}
	
	public User(String userName, String password, 
			String email, Job job, Location location, int birthdayYear) {
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.job = job;
		this.location = location;
		this.setBirthdayYear(birthdayYear);
	}
	
	public Critic makeCritic(String commentText, Job job, int salary) {
		return new Critic(this, this.comment(commentText), job, salary);
	}
	
	public Comment comment(String text) {
		return new Comment(this, text);
	}
		
	public int increaseReputation() {
		return ++this.reputation;
	}
	
	public int decreaseReputation() {
		return --this.reputation;
	}
	
	public int getReputation() {
		return this.reputation;
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
	
	public void setJob(Job job) {
		this.job = job;
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}

	public String getUserName() {
		return userName;
	}
	
	public int getBirthdayYear() {
		return birthdayYear;
	}

	public void setBirthdayYear(int birthdayYear) {
		this.birthdayYear = birthdayYear;
	}
	
	@Override
	protected void validate() {
     	if (isVoid(this.password.trim())) {
			this.addBrokenRule("Password", "El password es requerido.");
		}
		else {
			if ((this.password.length() < 6) || (this.password.length() > 20)) {
				this.addBrokenRule("Password", "El password debe tener como maximo 20 caracteres.");
			}
		}
     
     	if(isVoid(this.email.trim())) {
			this.addBrokenRule("Email", "El email es requerido.");
		} else {
			if (this.email.length() > 30) {
				this.addBrokenRule("Email", "El email debe tener como maximo 30 caracteres.");
			}
			Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		    Matcher m = p.matcher(email);
			if (!m.matches()) {
			  this.addBrokenRule("Email", "El email tiene formato invalido.");
			}
		}
     
		if (isVoid(userName.trim())) {
			this.addBrokenRule("UserName", "El nombre de usuario es requerido.");
		}
		else {
			if (userName.length() > 10) {
				this.addBrokenRule("UserName", "El nombre de usuario debe tener como maximo 10 caracteres.");
			}
		}
				
		if (this.job == null) {
			this.addBrokenRule("Job", "El trabajo actual del usuario es requerido.");
		} else {
			this.addBrokenRule(this.job.getBrokenRules());
		}
		
		if (this.birthdayYear >= 1950 && this.birthdayYear < Calendar.getInstance().get(Calendar.YEAR) - 10) {
			this.addBrokenRule("BirthdayYear", "El año de nacimiento es invalido.");
		}	
	}
	
}

// eof
