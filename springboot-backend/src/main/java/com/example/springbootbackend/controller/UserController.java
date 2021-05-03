package com.example.springbootbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootbackend.exception.ResourceNotFoundException;
import com.example.springbootbackend.model.CertificationDetails;
import com.example.springbootbackend.model.EducationDetails;
import com.example.springbootbackend.model.ExperienceDetails;
import com.example.springbootbackend.model.PersonalDetails;
import com.example.springbootbackend.model.ResumeDetails;
import com.example.springbootbackend.model.SkillsDetails;
import com.example.springbootbackend.model.UserInfo;
import com.example.springbootbackend.repository.CertificationDetailsRepository;
import com.example.springbootbackend.repository.EducationDetailsRepository;
import com.example.springbootbackend.repository.ExperienceDetailsRepository;
import com.example.springbootbackend.repository.PersonalDetailsRepository;
import com.example.springbootbackend.repository.SkillsDetailsRepository;
import com.example.springbootbackend.repository.UserInfoRepository;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1/") //standard endpoint being used for Rest APIs
public class UserController {
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private PersonalDetailsRepository personalDetailsRepository;
	
	@Autowired
	private EducationDetailsRepository educationDetailsRepository;
	
	@Autowired
	private ExperienceDetailsRepository experienceDetailsRepositoryr;
	
	@Autowired
	private SkillsDetailsRepository skillsDetailsRepository;
	
	@Autowired
	private CertificationDetailsRepository certificationDetailsRepository;

	//get all users
	@GetMapping("/all-users")
	public List<UserInfo> getAllUsers() {
		return userInfoRepository.findAll();
	}
	
	//create user api
	@PostMapping("/create-user")
	public UserInfo createNewUser(@RequestBody UserInfo userInfo) {
		return userInfoRepository.save(userInfo);
	}
	
	//get user by Id api
	@GetMapping("/users/{id}")
	public ResponseEntity<UserInfo> getUserById(@PathVariable Long id) {
		UserInfo userInfo = userInfoRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("User does not found with ID :"+id));
		return ResponseEntity.ok(userInfo);
	}
	
	//update User API
	@RequestMapping(value="/users/{id}",method = RequestMethod.PUT)
//	@PutMapping("/users/{id}/")
	public ResponseEntity<UserInfo> updateUser(@PathVariable Long id ,@RequestBody UserInfo userDetails) {
		UserInfo userInfo = userInfoRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("User does not found with ID :"+id));

		userInfo.setFirstName(userDetails.getFirstName());
		userInfo.setLastName(userDetails.getLastName());
		userInfo.setEmailId(userDetails.getEmailId());
		userInfo.setContactNo(userDetails.getContactNo());
		userInfo.setUserName(userDetails.getUserName());
		userInfo.setPassword(userDetails.getPassword());
		
		UserInfo updatedUser = userInfoRepository.save(userInfo);
		
		return ResponseEntity.ok(updatedUser);
	}
	
	//create resume details api
	@PostMapping("/create-resume")
	public void createNewResume(@RequestBody ResumeDetails resumeDetails) {
	
		PersonalDetails personalDetails = resumeDetails.getPersonalDetails();
		UserInfo userInfo = personalDetails.getUserInfo();
		personalDetailsRepository.save(personalDetails);
		
		EducationDetails educationDetailsArr[] = resumeDetails.getEducationDetails();		
		for (EducationDetails educationDetails : educationDetailsArr) {
			educationDetails.setUserInfo(userInfo);
			educationDetailsRepository.save(educationDetails);
		}
					
		ExperienceDetails experienceDetailsArr[] = resumeDetails.getExperienceDetails();
		for (ExperienceDetails experienceDetails : experienceDetailsArr) {
			experienceDetails.setUserInfo(userInfo);
			experienceDetailsRepositoryr.save(experienceDetails);
		}
		
		SkillsDetails skillsDetailsArr[] = resumeDetails.getSkillsDetails();
		for (SkillsDetails skillsDetails : skillsDetailsArr) {
			skillsDetails.setUserInfo(userInfo);
			skillsDetailsRepository.save(skillsDetails);
		}
		
		CertificationDetails certificationDetailsArr[] = resumeDetails.getCertificationDetails();
		for (CertificationDetails certificationDetails : certificationDetailsArr) {
			certificationDetails.setUserInfo(userInfo);
			certificationDetailsRepository.save(certificationDetails);
		}
	}
	
	//get resume details by Id api
	@GetMapping("/resume-details/{user_id}")
	public ResumeDetails getResumeDetailsById(@PathVariable Long user_id) {
		UserInfo userInfo = userInfoRepository.findById(user_id).
				orElseThrow(() -> new ResourceNotFoundException("User does not found with ID :"+user_id));
		
		ResumeDetails resumeDetails = new ResumeDetails();
//		PersonalDetails personalDetails = personalDetailsRepository.findByUserId(user_id);
		PersonalDetails personalDetails = personalDetailsRepository.findByUserInfo(userInfo);
		resumeDetails.setPersonalDetails(personalDetails);
		
		List<EducationDetails> educationsDetailsList = educationDetailsRepository.findByUserInfo(userInfo);
		EducationDetails[] educationDetailsArray = new EducationDetails[educationsDetailsList.size()];
		educationDetailsArray = educationsDetailsList.toArray(educationDetailsArray);
		resumeDetails.setEducationDetails(educationDetailsArray);
		
		List<ExperienceDetails> experienceDetailsList = experienceDetailsRepositoryr.findByUserInfo(userInfo);
		ExperienceDetails[] experienceDetailsArray = new ExperienceDetails[experienceDetailsList.size()];
		experienceDetailsArray = experienceDetailsList.toArray(experienceDetailsArray);
		resumeDetails.setExperienceDetails(experienceDetailsArray);
		
		List<SkillsDetails> skillsDetailsList = skillsDetailsRepository.findByUserInfo(userInfo);
		SkillsDetails[] skillsDetailsArray = new SkillsDetails[skillsDetailsList.size()];
		skillsDetailsArray = skillsDetailsList.toArray(skillsDetailsArray);
		resumeDetails.setSkillsDetails(skillsDetailsArray);
		
		List<CertificationDetails> certificationDetailsList = certificationDetailsRepository.findByUserInfo(userInfo);
		CertificationDetails[] certificationDetailsArray = new CertificationDetails[certificationDetailsList.size()];
		certificationDetailsArray = certificationDetailsList.toArray(certificationDetailsArray);
		resumeDetails.setCertificationDetails(certificationDetailsArray);

		return resumeDetails;
	}
	
	//update User API
	@RequestMapping(value="/resume-details/{user_id}",method = RequestMethod.PUT)
	public ResponseEntity<ResumeDetails> updateResumeDetails(@PathVariable Long user_id ,@RequestBody ResumeDetails resumeDetails) {
		UserInfo userInfo = userInfoRepository.findById(user_id).
				orElseThrow(() -> new ResourceNotFoundException("User does not found with ID :"+user_id));
		
		ResumeDetails resumeInfo = new ResumeDetails();

		PersonalDetails personalDetails = personalDetailsRepository.findByUserInfo(userInfo);
		personalDetails = resumeDetails.getPersonalDetails();
		resumeInfo.setPersonalDetails(personalDetails);
		personalDetailsRepository.save(personalDetails);
		
		List<EducationDetails> educationsDetailsList = educationDetailsRepository.findByUserInfo(userInfo);
		EducationDetails[] educationDetailsArray = new EducationDetails[educationsDetailsList.size()];
		educationDetailsArray = educationsDetailsList.toArray(educationDetailsArray);
		educationDetailsArray = resumeDetails.getEducationDetails();
		resumeInfo.setEducationDetails(educationDetailsArray);

		for (EducationDetails educationDetails : educationDetailsArray) {
			educationDetails.setUserInfo(userInfo);
			educationDetailsRepository.save(educationDetails);
		}
		
		List<ExperienceDetails> experienceDetailsList = experienceDetailsRepositoryr.findByUserInfo(userInfo);
		ExperienceDetails[] experienceDetailsArray = new ExperienceDetails[experienceDetailsList.size()];
		experienceDetailsArray = experienceDetailsList.toArray(experienceDetailsArray);
		experienceDetailsArray = resumeDetails.getExperienceDetails();
		resumeInfo.setExperienceDetails(experienceDetailsArray);
		
		for (ExperienceDetails experienceDetails : experienceDetailsArray) {
			experienceDetails.setUserInfo(userInfo);
			experienceDetailsRepositoryr.save(experienceDetails);
		}
		
		List<SkillsDetails> skillsDetailsList = skillsDetailsRepository.findByUserInfo(userInfo);
		SkillsDetails[] skillsDetailsArray = new SkillsDetails[skillsDetailsList.size()];
		skillsDetailsArray = skillsDetailsList.toArray(skillsDetailsArray);
		skillsDetailsArray = resumeDetails.getSkillsDetails();
		resumeInfo.setSkillsDetails(skillsDetailsArray);
		
		for (SkillsDetails skillsDetails : skillsDetailsArray) {
			skillsDetails.setUserInfo(userInfo);
			skillsDetailsRepository.save(skillsDetails);
		}
		
		List<CertificationDetails> certificationDetailsList = certificationDetailsRepository.findByUserInfo(userInfo);
		CertificationDetails[] certificationDetailsArray = new CertificationDetails[certificationDetailsList.size()];
		certificationDetailsArray = certificationDetailsList.toArray(certificationDetailsArray);
		certificationDetailsArray = resumeDetails.getCertificationDetails();
		resumeInfo.setCertificationDetails(certificationDetailsArray);
		
		for (CertificationDetails certificationDetails : certificationDetailsArray) {
			certificationDetails.setUserInfo(userInfo);
			certificationDetailsRepository.save(certificationDetails);
		}
		return ResponseEntity.ok(resumeInfo);
	}
}
