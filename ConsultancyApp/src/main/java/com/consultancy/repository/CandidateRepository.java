package com.consultancy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultancy.domain.CandidateInfo;

public interface CandidateRepository extends JpaRepository<CandidateInfo, Long>{
	
	List<CandidateInfo> findBySkillSetAndIsActive(String skillset,boolean isActive);
	List<CandidateInfo> findByIsActiveTrue();

}
