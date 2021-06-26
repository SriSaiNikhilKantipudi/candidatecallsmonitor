package com.candidate.candidatecalls.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.candidate.candidatecalls.dao.CandidateDAO;
import com.candidate.candidatecalls.model.Candidate;
import com.candidate.candidatecalls.model.Candidatecalls;
import com.candidate.candidatecalls.service.CandidateService;


@Service
public class CandidateServiceImpl implements CandidateService {
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private CandidateDAO dao;

	@Override
	public List<Candidate> getAllCandidates() {
		return dao.getCandidate();
	}

	@Override
	public int saveCandidate(Candidate can) {
	return dao.saveCandidate(can);
	}

	@Override
	public Candidate getCandidate(Candidate can, Integer id) {
		return dao.getCandidate(can,id);
	}

	@Override
	public int saveCandidatecalls(Candidatecalls ccal) {
		return dao.saveCandidatecalls(ccal);
	}
	
	@Override
	public int authenticateUser( String userId, String password)
	{
		return dao.authenticateUser(userId,password);
	}
	

}
