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
@Table(name = "certification_details")
public class CertificationDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "certification_id")
	private long certificationId;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;
	
	@Column(name = "certification_title")
	private String certificationTitle;
	
	@Column(name = "certification_date")
	private String certificationDate;
	
	@Column(name = "duration_of_completion")
	private String durationOfCompletion;
	
	@Column(name = "institute_name")
	private String instituteName;
	
	@Column(name = "technology")
	private String technology;
	
	public CertificationDetails() {
		
	}

	public CertificationDetails(long certificationId, UserInfo userInfo, String certificationTitle,
			String certificationDate, String durationOfCompletion, String instituteName, String technology) {
		super();
		this.certificationId = certificationId;
		this.userInfo = userInfo;
		this.certificationTitle = certificationTitle;
		this.certificationDate = certificationDate;
		this.durationOfCompletion = durationOfCompletion;
		this.instituteName = instituteName;
		this.technology = technology;
	}

	public long getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(long certificationId) {
		this.certificationId = certificationId;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getCertificationTitle() {
		return certificationTitle;
	}

	public void setCertificationTitle(String certificationTitle) {
		this.certificationTitle = certificationTitle;
	}

	public String getCertificationDate() {
		return certificationDate;
	}

	public void setCertificationDate(String certificationDate) {
		this.certificationDate = certificationDate;
	}

	public String getDurationOfCompletion() {
		return durationOfCompletion;
	}

	public void setDurationOfCompletion(String durationOfCompletion) {
		this.durationOfCompletion = durationOfCompletion;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}
	
	
}
