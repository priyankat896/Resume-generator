package com.example.springbootbackend.model;

public class ResumeDetails {

	private PersonalDetails personalDetails;
	private EducationDetails educationDetails[];
	private ExperienceDetails experienceDetails[];
	private SkillsDetails skillsDetails[];
	private CertificationDetails certificationDetails[];
	
	public ResumeDetails() {
		
	}
	
	public ResumeDetails(PersonalDetails personalDetails, EducationDetails[] educationDetails,
			ExperienceDetails[] experienceDetails, SkillsDetails[] skillsDetails,
			CertificationDetails[] certificationDetails) {
		super();
		this.personalDetails = personalDetails;
		this.educationDetails = educationDetails;
		this.experienceDetails = experienceDetails;
		this.skillsDetails = skillsDetails;
		this.certificationDetails = certificationDetails;
	}
	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}
	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}
	public EducationDetails[] getEducationDetails() {
		return educationDetails;
	}
	public void setEducationDetails(EducationDetails[] educationDetails) {
		this.educationDetails = educationDetails;
	}
	public ExperienceDetails[] getExperienceDetails() {
		return experienceDetails;
	}
	public void setExperienceDetails(ExperienceDetails[] experienceDetails) {
		this.experienceDetails = experienceDetails;
	}
	public SkillsDetails[] getSkillsDetails() {
		return skillsDetails;
	}
	public void setSkillsDetails(SkillsDetails[] skillsDetails) {
		this.skillsDetails = skillsDetails;
	}
	public CertificationDetails[] getCertificationDetails() {
		return certificationDetails;
	}
	public void setCertificationDetails(CertificationDetails[] certificationDetails) {
		this.certificationDetails = certificationDetails;
	}

	
}
