package com.consultancy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="candidate")
public class CandidateInfo {
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CANDIDATE_ID")
	private long cId;
	@NotNull
	@Column(name="CANDIDATE_NAME")
	private String cName;
	@NotNull
	@Column(name="SKILL_SET")
	private String skillSet;
	@NotNull
	@Column(name="ADDRESS")
	private String address;
	@Column(name="EMAIL")
	@Email
	private String email;
	@Column(name="MOB_NO")
	@Size(min=10,max=11)
	private String mobNo;
	private boolean isActive;
	
	
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	public long getcId() {
		return cId;
	}
	public void setcId(long cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	
	
	
}
