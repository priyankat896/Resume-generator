package com.example.springbootbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "personal_details")
public class PersonalDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personal_details_id")
	private long personalDetailsId;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email_Id")
	private String emailId;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "contact_no")
	private String contactNo;
	
	@Column(name = "social_profile")
	private String socialProfile;

	public PersonalDetails() {
		
	}
	
	public PersonalDetails(Long id, UserInfo userInfo, String name, String emailId, String address, String contactNo,
			String socialProfile) {
		super();
		this.personalDetailsId = id;
		this.userInfo = userInfo;
		this.name = name;
		this.emailId = emailId;
		this.address = address;
		this.contactNo = contactNo;
		this.socialProfile = socialProfile;
	}

	public Long getId() {
		return personalDetailsId;
	}

	public void setId(Long id) {
		this.personalDetailsId = id;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getSocialProfile() {
		return socialProfile;
	}

	public void setSocialProfile(String socialProfile) {
		this.socialProfile = socialProfile;
	}
	
	
}

