package com.candidate.candidatecalls.model;

import java.util.ArrayList;
import java.util.List;

public class Authentication {
	private String userId;
	private String password;
	private List<Candidate> candidate= new ArrayList<>(); 
	
	public List<Candidate> getCandidate() {
		return candidate;
	}
	public void setCandidate(List<Candidate> candidate) {
		this.candidate = candidate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
