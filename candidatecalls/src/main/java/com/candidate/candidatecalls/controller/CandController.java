package com.candidate.candidatecalls.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.ILoggerFactory;
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

public class MITApplication{
public static String GlobalApplicationNAme= "this si for MIT";
}

@Component
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class CandController {
/*
	// get data from postbody and load it into specific type typeof Candidate
	//Candidate candidate = new Candidate();
	candidate.id = datafrom Post body.ID;

	new CardController().savecan(candidate); //CardController  -> SaveCan
	// CandidateCalls --> global memory -> static members
	*/
	@Autowired
	private CanService canservice;
	@Autowired
	private ILoggerFactory _logger;

	public static Map<Integer,Candidate> candidates = new HashMap<>();
	

	@GetMapping("/candidate/{id}")
	public ResponseEntity <Candidate>getCandidate(@PathVariable("id")Integer id,Candidate can) {
		/* can.setId(id); */
		MITApplication.GlobalApplicationNAme = "Uopdated one";
		return new ResponseEntity <Candidate>(canservice.getCand(can,id),HttpStatus.OK);
	}
	
	@GetMapping("/candidate") 
	  public ResponseEntity<List<Candidate>>getCandidateAll() {
		  return new ResponseEntity<List<Candidate>>(canservice.getAllCan(),HttpStatus.OK);
		  }
	 
	
	@PostMapping(value="/candidate")
	public ResponseEntity<Integer> saveCan(@RequestBody Candidate can) {
		try{

		}catch(Exception ex){
			_logger.getLogger('test').error(ex.ToString(), can.ToJson());
		}
				return new ResponseEntity<>(canservice.saveCan(can),HttpStatus.OK);
	}
	
	
	//Candidate call post api
	// SaveCandidate_ShouldTake_CandiddateID_and_Body_REturns_Success
	// SaveCandidate_ShouldTake_CandiddateID_and_Body_REturns_Exception
	
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

	
	
 
}
