package com.example.springbootbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootbackend.model.ExperienceDetails;
import com.example.springbootbackend.model.UserInfo;

public interface ExperienceDetailsRepository extends JpaRepository<ExperienceDetails, Long> {
	List<ExperienceDetails> findByUserInfo(UserInfo user_id);

}
