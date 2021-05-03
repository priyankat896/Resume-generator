package com.example.springbootbackend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userInfo")
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
	private long userId;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PersonalDetails personalDetails;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private EducationDetails educationDetails;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ExperienceDetails experienceDetails;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private SkillsDetails skillsDetails;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CertificationDetails certificationDetails;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_Id")
	private String emailId;
	
	@Column(name = "contact_no")
	private String contactNo;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	public UserInfo() {
		
	}

	public UserInfo(long userId, String firstName, String lastName, String emailId, String contactNo, String userName,
			String password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.contactNo = contactNo;
		this.userName = userName;
		this.password = password;
	}

	public long getId() {
		return userId;
	}

	public void setId(long userId) {
		this.userId = userId;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
