package com.candidate.candidatecalls.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.candidate.candidatecalls.model.Candidate;
import com.candidate.candidatecalls.model.Candidatecalls;



@Service
public interface CanService {
	
	public List<Candidate> getAllCan();

	public int saveCan(Candidate can);
	
	public Candidate getCand(Candidate can, Integer id);

	public int saveCcal(Candidatecalls ccal);
	


}
