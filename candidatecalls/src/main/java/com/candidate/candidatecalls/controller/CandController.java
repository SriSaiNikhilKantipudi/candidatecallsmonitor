package com.candidate.candidatecalls.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.candidate.candidatecalls.model.Authentication;
import com.candidate.candidatecalls.model.Candidate;
import com.candidate.candidatecalls.model.Candidatecalls;
import com.candidate.candidatecalls.service.CanService;



@Component
@RestController
@RequestMapping("/api/v1")
public class CandController {
	
	@Autowired
	private CanService canservice;

	private static Map<Integer,Candidate> candidates = new HashMap<>();
	
	
	@GetMapping("/can/{id}")
	public ResponseEntity <Candidate>getCandidate(@PathVariable("id")Integer id,Candidate can) {
		/* can.setId(id); */  
		return new ResponseEntity <Candidate>(canservice.getCand(can,id),HttpStatus.OK);
	}
	
	@GetMapping("/can") 
	  public ResponseEntity<List<Candidate>>getCandidateAll() {
		  return new ResponseEntity<List<Candidate>>(canservice.getAllCan(),HttpStatus.OK);
		  }
	 
	
	@PostMapping(value="/can")
	public ResponseEntity<Integer> saveCan(@RequestBody Candidate can) {
		
				return new ResponseEntity<>(canservice.saveCan(can),HttpStatus.OK);
	}
	
	
	//Candidate call post api
	
	@PostMapping(value="/can/{candidateid}/candidateCall")
	public ResponseEntity<Integer> saveCan(@PathVariable("candidateid")Integer candidateid,@RequestBody Candidatecalls ccal,Candidate can) {
		can = canservice.getCand(can, candidateid);
		ccal.setCandidate(can);
		
		
		return new ResponseEntity<>(canservice.saveCcal(ccal),HttpStatus.OK);
	}
	
	
	//Authentication API
	
		@PostMapping(value= "/can/auth")
		public ResponseEntity<Integer> auth(@RequestBody Authentication authentication, Candidate can)
		{
			List<Candidate> can1 = canservice.getAllCan();
			authentication.setCandidate(can1);
			return new ResponseEntity<>(canservice.authenticateUser(authentication.getUserId(),authentication.getPassword()),HttpStatus.OK);
		}
 
}
