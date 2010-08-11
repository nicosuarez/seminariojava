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
	public static final String EMAIL = "email";
	
	private String userName;
	private String password;
	private String email;
	private int birthdayYear;
	private String industryName;
	private String jobName;
	private String country;
	private String state; 
	private int reputation;
	
	@SuppressWarnings("unused")
	private int version; //To concurrency control in Hibernate
	
	public User() {
		// Hibernate requirement
	}
	
	public User(String userName, String password, 
			String email, String industryName, String jobName, String country, String state, int birthdayYear) {
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.industryName = industryName;
		this.jobName = jobName;
		this.country = country;
		this.state = state;
		this.birthdayYear = birthdayYear;
	}
	
	public Critic makeCritic(String commentText, Industry industry, Job job, int salary) {
		return new Critic(this, this.comment(commentText), industry, job, salary);
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
		return (this.reputation < BusinessRules.USER_ACTIVE_TRESHOLD);
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
		return Job.getJob(jobName);
	}
	
	public Industry getIndustry() {
		return Industry.getIndustry(industryName);
	}

	public String getCountry() {
		return this.country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getState() {
		return this.state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getBirthdayYear() {
		return birthdayYear;
	}

	public void setBirthdayYear(int birthdayYear) {
		this.birthdayYear = birthdayYear;
	}
	
	public void setBirthdayYear(String birthdayYear) {
		if(!isVoid(birthdayYear)) {
			this.birthdayYear = Integer.valueOf(birthdayYear);
		}
		else {
			this.birthdayYear = 0;
		}
	}
	
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
				
		if(this.isVoid(industryName) || this.isVoid(jobName) ) {
			this.addBrokenRule("Job", "El trabajo es requerido.");
		}
		
		if ((this.birthdayYear < 1950) || (this.birthdayYear >= (Calendar.getInstance().get(Calendar.YEAR) - 10))) {
			this.addBrokenRule("BirthdayYear", "El año de nacimiento es invalido.");
		}	
	}
	
}

// eof
