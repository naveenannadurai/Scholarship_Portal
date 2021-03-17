package com.lti.adminservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lti.adminservice.entities.Scholarship;

@Service
@Transactional
public class ScholarshipDaoImpl implements ScholarshipDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public int registerScholarship(Scholarship scholar) {

		Scholarship sc = em.merge(scholar);
		return sc.getScholarshipid();
	}

	@Override
	public List<Scholarship> getScholarship() {
		String sql = "select app from Scholarship app";
		Query qry = em.createQuery(sql);
		
		@SuppressWarnings("unchecked")
		List<Scholarship> list = qry.getResultList();
		return list;
	}

	@Override
	public void delete(int id) {
		Scholarship ss = em.find(Scholarship.class, id);
		em.remove(ss);
		
	}

}
