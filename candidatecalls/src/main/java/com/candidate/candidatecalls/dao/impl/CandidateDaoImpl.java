package com.candidate.candidatecalls.dao.impl;


import java.util.Date;
import java.util.List;



import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candidate.candidatecalls.dao.CandidateDAO;
import com.candidate.candidatecalls.model.Candidate;
import com.candidate.candidatecalls.model.Candidatecalls;


@Service
public class CandidateDaoImpl implements CandidateDAO{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	private static final String ADMIN="admin";
 
	@Override
	public List<Candidate> getCandidate() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Candidate>   canList    = session.createQuery("from Candidate").list();
       
        return canList;
       
	}


	@Override
	public int saveCandidate(Candidate candidate) {
		Session session = this.sessionFactory.getCurrentSession();
		if(candidate.getName()!=null&& candidate.getPassword()!=null&&candidate.getUserid()!=null)
		{
		session.save(candidate);
		}
		else
		{
			return 0;
		}
		return 1;
	}


	@Override
	public Candidate getCandidate(Candidate can, Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Candidate canList = (Candidate) session.get(Candidate.class,id);
        return canList;
	}


	@Override
	public int saveCandidatecalls(Candidatecalls candidatecalls) {
		Session session = this.sessionFactory.getCurrentSession();
		if(candidatecalls.getCompanyname()!=null)
		{
		Date date = new Date();
		candidatecalls.setDateofcall(date);
		session.save(candidatecalls);
		}
		else
		{
			return 0;
		}
		return 1;
	}

	@Override 
	public int authenticateUser(String userId, String password) {
		
	  if(userId.equals(ADMIN)&& password.equals(ADMIN))
		  return 2; 
	  
	  String hql = "FROM Candidate c WHERE c.userid=\'"+userId+"\'"; 
	  Session session = this.sessionFactory.getCurrentSession();
	  Query q = session.createQuery(hql); 
	  String actualPassword = (((Candidate)(q.uniqueResult())).getPassword()).toString();
	  
	  if(actualPassword.equals(password)) 
		  return 1; 
	  else 
		  return 0; 
	  }


	@Override
	public List<Candidatecalls> getCandidateCallList(Candidate can, Integer id) {
		List<Candidatecalls> sao = null;
		Session session = this.sessionFactory.getCurrentSession();
		Candidate canList = (Candidate) session.get(Candidate.class,id);
		if(canList != null) {
			sao =canList.getCcalls();
		}
				
        return sao;
	}

	@Override 
	public int deleteCandidateById(int id, Candidate can) { 
	  
	  
	  return 1;
	  }

	//update candidate details
	@Override
	public int updateCandidate(int id, Candidate can) {
	Session session = this.sessionFactory.getCurrentSession();
		Transaction tx= session.beginTransaction();
		if(can.getName()!=null&& can.getPassword()!=null&&can.getUserid()!=null)
		{
		Candidate v = (Candidate)session.load(Candidate.class, id);
		
		v.setName(can.getName());
	
		v.setPassword(can.getPassword());
		
		v.setUserid(can.getUserid());
		session.update(v);

		tx.commit();
		}
		else
		{
			return 0;
		}
		return 1;
		
	}

	//update candidate calls
	@Override
	public int updateCandidateCall(int id, Candidatecalls can) {

		Session session = this.sessionFactory.getCurrentSession(); //
		// Hibernate.initialize(can); // session.update(can); Candidatecalls v1=
		Transaction tx = session.beginTransaction();
		if(can.getCompanyname()!=null)
		{
		Candidatecalls v1 = (Candidatecalls) session.load(Candidatecalls.class, id);
		v1.setCompanyname(can.getCompanyname());
		session.update(v1);
		tx.commit();
		}
		else
		{
			return 0;
		}
		return 1;
	} 
	
	
	


}
	



