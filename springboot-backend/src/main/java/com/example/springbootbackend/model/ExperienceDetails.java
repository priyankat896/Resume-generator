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
@Table(name = "experience_details")
public class ExperienceDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "experience_details_id")
	private long experienceDetailsId;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;
	
	@Column(name = "employer")
	private String employer;
	
	@Column(name = "job_title")
	private String jobTitle;
	
	@Column(name = "expeience_in_months")
	private int experienceInMonths;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	public ExperienceDetails() {
		
	}

	public ExperienceDetails(long experienceDetailsId, UserInfo userInfo, String employer, String jobTitle,
			int experienceInMonths, String jobDescription) {
		super();
		this.experienceDetailsId = experienceDetailsId;
		this.userInfo = userInfo;
		this.employer = employer;
		this.jobTitle = jobTitle;
		this.experienceInMonths = experienceInMonths;
		this.jobDescription = jobDescription;
	}

	public long getExperienceDetailsId() {
		return experienceDetailsId;
	}

	public void setExperienceDetailsId(long experienceDetailsId) {
		this.experienceDetailsId = experienceDetailsId;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getExperienceInMonths() {
		return experienceInMonths;
	}

	public void setExperienceInMonths(int experienceInMonths) {
		this.experienceInMonths = experienceInMonths;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	
	
}
