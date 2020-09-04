package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.domain.CandidateInfo;

public interface CandidateRepository extends JpaRepository<CandidateInfo, Long>{

}
