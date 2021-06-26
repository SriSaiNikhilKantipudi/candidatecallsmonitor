package com.candidate.candidatecalls.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.candidate.candidatecalls.model.Authentication;
//import com.candidate.candidatecalls.model.Authentication;
import com.candidate.candidatecalls.model.Candidate;
import com.candidate.candidatecalls.model.Candidatecalls;
import com.candidate.candidatecalls.service.CanService;



@Component
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class CandController {
	
	@Autowired
	private CanService canservice;

	private static Map<Integer,Candidate> candidates = new HashMap<>();
	
	
	@GetMapping("/candidate/{id}")
	public ResponseEntity <Candidate>getCandidate(@PathVariable("id")Integer id,Candidate can) {
		/* can.setId(id); */  
		return new ResponseEntity <Candidate>(canservice.getCand(can,id),HttpStatus.OK);
	}
	
	@GetMapping("/candidate") 
	  public ResponseEntity<List<Candidate>>getCandidateAll() {
		  return new ResponseEntity<List<Candidate>>(canservice.getAllCan(),HttpStatus.OK);
		  }
	 
	
	@PostMapping(value="/candidate")
	public ResponseEntity<Integer> saveCan(@RequestBody Candidate can) {
		
				return new ResponseEntity<>(canservice.saveCan(can),HttpStatus.OK);
	}
	
	
	//Candidate call post api
	
	@PostMapping(value="/candidate/{candidateid}/candidateCall")
	public ResponseEntity<Integer> saveCan(@PathVariable("candidateid")Integer candidateid,@RequestBody Candidatecalls ccal,Candidate can) {
		can = canservice.getCand(can, candidateid);
		ccal.setCandidate(can);
		
		
		return new ResponseEntity<>(canservice.saveCcal(ccal),HttpStatus.OK);
	}
	
	
	// Authentication API
	@PostMapping(value= "/candidate/auth")
	public ResponseEntity<Integer> auth(@RequestBody Authentication authentication, Candidate can)
	{
		List<Candidate> can1 = canservice.getAllCan();
		authentication.setCandidate(can1);
		return new ResponseEntity<>(canservice.authenticateUser(authentication.getUserId(),authentication.getPassword()),HttpStatus.OK);
	}													

	
	// Get Individual Candidate Call list
	@GetMapping(value = "/candidateCallList/{id}")
	public ResponseEntity<List<Candidatecalls>> callList(@PathVariable("id") Integer id, Candidate can)
	{
		return new ResponseEntity <List<Candidatecalls>>(canservice.getCandidateCallList(can,id),HttpStatus.OK);
	}
	
	@GetMapping(value = "/deleteCandidateById/{id}")
	public ResponseEntity<Integer> deleteCandidate(@PathVariable("id")Integer id,Candidate can){
		return new ResponseEntity<Integer>(canservice.deleteCandidateById(id,can),HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateCandidateById/{id}")
	public int updateCan(@RequestBody Candidate can, @PathVariable("id") int id) {
		return canservice.updateCandidate(id,can);
	}
	
	@PutMapping(value = "/updateCandidateCallsById/{id}")
	public int updateCCalls(@RequestBody Candidatecalls can, @PathVariable("id") int id) {
		return canservice.updateCandidateCall(id, can);
	}
	
	
 
}
