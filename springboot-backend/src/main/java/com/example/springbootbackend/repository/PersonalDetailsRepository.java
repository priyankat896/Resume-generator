package com.example.springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.springbootbackend.model.PersonalDetails;
import com.example.springbootbackend.model.UserInfo;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long>{

//	  @Query(value = "SELECT * FROM personal_details WHERE user_id = ?0", nativeQuery = true)
//	  User findByEmailAddress(String emailAddress);
	  
//	  @Query("SELECT * FROM personal_details WHERE user_id = ?1")
//	  PersonalDetails findByUserInfo(Long user_id);
//	  
//	PersonalDetails findByUserInfo(Long user_id);
	PersonalDetails findByUserInfo(UserInfo userInfo);
}
