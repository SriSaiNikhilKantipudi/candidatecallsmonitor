package com.candidate.candidatecalls.dao.impl;


import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.candidate.candidatecalls.dao.CanDAO;
import com.candidate.candidatecalls.model.Candidate;
import com.candidate.candidatecalls.model.Candidatecalls;


@Service
public class CanDaoImpl implements CanDAO{
	
	@Autowired
    private SessionFactory sessionFactory;
 



	@Override
	public List<Candidate> getCan() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Candidate>  canList = session.createQuery("from Candidate").list();
        return canList;
	}


	@Override
	public int saveCan(Candidate can) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(can);
		return 1;
	}


	@Override
	public Candidate getCand(Candidate can, Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Candidate canList = (Candidate) session.get(Candidate.class,id);
        return canList;
	}


	@Override
	public int saveCcal(Candidatecalls ccal) {
		Session session = this.sessionFactory.getCurrentSession();
		Date date = new Date();
		ccal.setDateofcall(date);
		session.save(ccal);
		return 1;
	}

	@Override public int authenticateUser(String userId, String password) {
		
	  String admin="admin"; 
	  if(userId.equals(admin)&& password.equals(admin))
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

}
	



