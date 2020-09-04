package com.consultancy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultancy.domain.CandidateInfo;
import com.consultancy.repository.CandidateRepository;


@RestController
@RequestMapping("/")
public class CandidateController {
	
	@Autowired
	CandidateRepository cRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(CandidateController.class);
	
	@PostMapping("/addCandidate")
	public String addCandidate(@RequestBody CandidateInfo cReqst) {
		logger.info("Add candidate started");
		return cRepository.save(cReqst).getcId()+"";
	}
	
	@GetMapping("/getCandidateFromConsultancy/{skillset}")
	public ResponseEntity<List<CandidateInfo>> getCandidateFromConsultancy(@PathVariable(name="skillset") String skill) {
		logger.info("Get candidate started");
		List<CandidateInfo> cInfo=cRepository.findBySkillSetAndIsActive(skill,true);
		return new ResponseEntity<List<CandidateInfo>>(cInfo,HttpStatus.OK);
	}
	
	@GetMapping("/getActiveCandidateFromConsultancy/{skillset}")
	public ResponseEntity<List<CandidateInfo>> getActiveCandidateFromConsultancy() {
		logger.info("Get active candidates started");
		List<CandidateInfo> cInfo=cRepository.findByIsActiveTrue();
		return new ResponseEntity<List<CandidateInfo>>(cInfo,HttpStatus.OK);
	}

}
