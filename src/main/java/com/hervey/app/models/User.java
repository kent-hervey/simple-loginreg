package com.hervey.app.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //this will be referenced in repository class
	
	@NotEmpty
	@Size(min=2, message = "username must be at least two characters")
	private String userName;
	
	@NotEmpty
	@Size(min=2, message = "enter valid location of at least two characters")
	private String userLocation;
	
	@NotNull
	private Integer numLogins=0;
	
	private String sex;
	
	
	private Boolean goldStatus=true;
	
	private String personalDescription;
	
	
	
	
	@Email
	@NotEmpty
	private String email;
	
	@NotEmpty
	@Size(min=8, message = "password must be 8 or more characters")
	private String password;
	
	@Transient
	private String passwordConfirmation;
	
	@Column(updatable=false)
	private Date createdAt;
	
	//no conditions on updatedAt
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	//end instance variable declarations
	

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userLocation=" + userLocation + ", numLogins="
				+ numLogins + ", sex=" + sex + ", goldStatus=" + goldStatus + ", personalDescription="
				+ personalDescription + ", email=" + email + ", password=" + password + ", passwordConfirmation="
				+ passwordConfirmation + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPersonalDescription() {
		return personalDescription;
	}

	public void setPersonalDescription(String personalDescription) {
		this.personalDescription = personalDescription;
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

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Boolean getGoldStatus() {
		return goldStatus;
	}

	public void setGoldStatus(Boolean goldStatus) {
		this.goldStatus = goldStatus;
	}

	public String getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	public Integer getNumLogins() {
		return numLogins;
	}

	public void setNumLogins(Integer numLogins) {
		this.numLogins = numLogins;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
