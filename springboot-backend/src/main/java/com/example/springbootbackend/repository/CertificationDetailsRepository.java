package com.example.springbootbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootbackend.model.CertificationDetails;
import com.example.springbootbackend.model.UserInfo;

public interface CertificationDetailsRepository extends JpaRepository<CertificationDetails, Long> {
	List<CertificationDetails> findByUserInfo(UserInfo user_id);

}
