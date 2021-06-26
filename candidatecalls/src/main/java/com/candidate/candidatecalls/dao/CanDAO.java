package com.candidate.candidatecalls.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.candidate.candidatecalls.model.Candidate;
import com.candidate.candidatecalls.model.Candidatecalls;

@Service
@Repository
public interface CandidateDAO {
	

public List<Candidate> getCandidate();

public int saveCandidate(Candidate can);

public Candidate getCandidate(Candidate can, Integer id);

public int saveCandidatecalls(Candidatecalls ccal);

public int authenticateUser( String userId, String password);





}
