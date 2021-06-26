package com.candidate.candidatecalls.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="candidatedetails")
public class Candidate {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "userid")
	private String userid;
	
	@Column(name = "password")
	private String password;
	
	@JsonBackReference
	@OneToMany
	@JoinColumn(name="candidate_id")
	private List<Candidatecalls> ccalls;
	
            

	public Candidate() {
	}
	
	
	public Candidate(Integer id,String name, String userid, String password ) {
		super();
		this.id = id;
		this.name = name;
		this.userid = userid;
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Candidatecalls> getCcalls() {
		return ccalls;
	}


	public void setCcalls(List<Candidatecalls> ccalls) {
		this.ccalls = ccalls;
	}



	
	
	
	

}
    
