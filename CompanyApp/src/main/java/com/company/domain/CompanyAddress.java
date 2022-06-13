package com.company.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class CompanyAddress {

	@EmbeddedId
	private AddressId id;

	@Column(name = "CANDIDATE_ADDRESS")
	private String addresses;

	@ManyToOne(fetch = FetchType.LAZY)
	public CandidateInfo candidate;

	@Data
	@Embeddable
	public static class AddressId implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Column(name = "CANDIDATE_ID")
		private long cId;

		@Column(name = "LOCATION_ID")
		private long locId;
	}

}
