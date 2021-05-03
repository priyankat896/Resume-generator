package com.example.springbootbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootbackend.model.EducationDetails;
import com.example.springbootbackend.model.UserInfo;

public interface EducationDetailsRepository extends JpaRepository<EducationDetails, Long>{
	List<EducationDetails> findByUserInfo(UserInfo user_id);
}
