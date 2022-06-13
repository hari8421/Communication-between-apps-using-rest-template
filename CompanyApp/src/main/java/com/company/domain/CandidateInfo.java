package com.company.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Description;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="candidate")
@Data
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
	
	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="CANDIDATE_ID")
    public List<CompanyAddress> addressList = new LinkedList<CompanyAddress>();
	
		
	
}
