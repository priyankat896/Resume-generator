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
@Table(name = "skills_details")
public class SkillsDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "skill_id")
	private long skillId;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;
	
	@Column(name = "technology")
	private String technology;

	@Column(name = "expertise_level")
	private String expertiseLevel;

	public SkillsDetails() {
		
	}
	
	public SkillsDetails(long skillId, UserInfo userInfo, String technology, String expertiseLevel) {
		super();
		this.skillId = skillId;
		this.userInfo = userInfo;
		this.technology = technology;
		this.expertiseLevel = expertiseLevel;
	}

	public long getSkillId() {
		return skillId;
	}

	public void setSkillId(long skillId) {
		this.skillId = skillId;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getExpertiseLevel() {
		return expertiseLevel;
	}

	public void setExpertiseLevel(String expertiseLevel) {
		this.expertiseLevel = expertiseLevel;
	}
	
	
}
