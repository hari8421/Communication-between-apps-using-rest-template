package com.company.controller;

import java.nio.charset.Charset;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.company.repository.CandidateRepository;

@RestController
@RequestMapping("/")
public class CandidateController {
	
	@Autowired
	CandidateRepository cRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(CandidateController.class);
	
	@GetMapping("/getCandidateFromConsultancy/{skillset}")
	public <T> ResponseEntity<String> getCandidateFromConsultancy(@PathVariable(name="skillset") String skill) {
		logger.info("Contacting consultancy");
		RestTemplate rTemp=new RestTemplate();
		ResponseEntity<String> candidateList=rTemp.exchange
				 ("http://localhost:9002/getCandidateFromConsultancy/"+skill, HttpMethod.GET, new HttpEntity<T>(createHeaders("hari", "pass")), String.class);

			
		return candidateList;
	}
	HttpHeaders createHeaders(String username, String password){
		   return new HttpHeaders() {
			private static final long serialVersionUID = 1L;

		{
		         String auth = username + ":" + password;
		         byte[] encodedAuth = Base64.encodeBase64( 
		            auth.getBytes(Charset.forName("US-ASCII")) );
		         String authHeader = "Basic " + new String( encodedAuth );
		         set( "Authorization", authHeader );
		      }};
		}
}
