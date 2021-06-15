package com.candidate.candidatecalls.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.candidate.candidatecalls.dao.CanDAO;
import com.candidate.candidatecalls.model.Candidate;
import com.candidate.candidatecalls.model.Candidatecalls;
import com.candidate.candidatecalls.service.CanService;


@Service
public class CanServiceImpl implements CanService {
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private CanDAO dao;

	@Override
	public List<Candidate> getAllCan() {
		return dao.getCan();
	}

	@Override
	public int saveCan(Candidate can) {
	return dao.saveCan(can);
	}

	@Override
	public Candidate getCand(Candidate can, Integer id) {
		return dao.getCand(can,id);
	}

	@Override
	public int saveCcal(Candidatecalls ccal) {
		return dao.saveCcal(ccal);
	}
	
	@Override
	public int authenticateUser( String userId, String password)
	{
		return dao.authenticateUser(userId,password);
	}
	

}