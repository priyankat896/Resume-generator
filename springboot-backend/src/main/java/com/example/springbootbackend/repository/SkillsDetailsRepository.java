package com.example.springbootbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootbackend.model.SkillsDetails;
import com.example.springbootbackend.model.UserInfo;

public interface SkillsDetailsRepository extends JpaRepository<SkillsDetails, Long>{
	List<SkillsDetails> findByUserInfo(UserInfo user_id);

}
