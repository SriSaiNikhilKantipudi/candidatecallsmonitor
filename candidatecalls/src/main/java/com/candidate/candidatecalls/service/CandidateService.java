package com.candidate.candidatecalls.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.candidate.candidatecalls.model.Candidate;
import com.candidate.candidatecalls.model.Candidatecalls;



@Service
<<<<<<< HEAD
public interface CandidateService
{
	
	public List<Candidate> getAllCandidates();

	public int saveCandidate(Candidate can);
	
	public Candidate getCandidate(Candidate can, Integer id);

	public int saveCandidatecalls(Candidatecalls ccal);
=======
public interface CanService
{
	
	public List<Candidate> getAllCan();

	public int saveCan(Candidate can);
	
	public Candidate getCand(Candidate can, Integer id);

	public int saveCcal(Candidatecalls ccal);
>>>>>>> main
	
	public int authenticateUser(String userId, String password);

	public List<Candidatecalls> getCandidateCallList(Candidate can, Integer id);
	
	public int deleteCandidateById(int id, Candidate can);
	
	public int updateCandidate(int id, Candidate can);
	

	public int updateCandidateCall(int id, Candidatecalls can);

	

	

	

	//public List<Candidatecalls> getCandidateCalls(List<Candidatecalls> can1);

	

}
