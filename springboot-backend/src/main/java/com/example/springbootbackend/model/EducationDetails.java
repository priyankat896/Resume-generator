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
@Table(name = "education_details")
public class EducationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "education_details_id")
	private long educationDetailsId;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;
	
	@Column(name = "course")
	private String course;
	
	@Column(name = "college")
	private String college;
	
	@Column(name = "university")
	private String university;
	
	@Column(name = "passing_year")
	private String passingYear;
	
	@Column(name = "percentage")
	private String percentage;

	public EducationDetails() {
		
	}
	
	public EducationDetails(long educationDetailsId, UserInfo userInfo, String course, String college,
			String university, String passingYear, String percentage) {
		super();
		this.educationDetailsId = educationDetailsId;
		this.userInfo = userInfo;
		this.course = course;
		this.college = college;
		this.university = university;
		this.passingYear = passingYear;
		this.percentage = percentage;
	}

	public long getEducationDetailsId() {
		return educationDetailsId;
	}

	public void setEducationDetailsId(long educationDetailsId) {
		this.educationDetailsId = educationDetailsId;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getPassingYear() {
		return passingYear;
	}

	public void setPassingYear(String passingYear) {
		this.passingYear = passingYear;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	
	
}
