package com.candidate.candidatecalls.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.candidate.candidatecalls.model.Candidate;
import com.candidate.candidatecalls.model.Candidatecalls;

@Service
@Repository
public interface CanDAO {
	

public List<Candidate> getCan();

public int saveCan(Candidate can);

public Candidate getCand(Candidate can, Integer id);

public int saveCcal(Candidatecalls ccal);







}
