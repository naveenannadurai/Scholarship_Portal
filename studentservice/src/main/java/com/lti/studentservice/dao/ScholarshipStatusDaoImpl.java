package com.lti.studentservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lti.studentservice.entities.ScholarshipStatus;

@Service
@Transactional
public class ScholarshipStatusDaoImpl implements ScholarshipStatusDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public int registerStatus(ScholarshipStatus status) {
		ScholarshipStatus state = em.merge(status);
		return state.getStatusId();
	}

	@Override
	public void approve(int scholarid, int application) {

		int i = (int) em.createQuery(
				"select app.statusId from ScholarshipStatus app where app.scholarshipId=:id and app.applicationNumber=:id1")
				.setParameter("id1", application).setParameter("id", scholarid).getSingleResult();

		ScholarshipStatus sch = em.find(ScholarshipStatus.class, i);
		sch.setStatus("Approved");
		em.merge(sch);
	}

	@Override
	public void reject(int scholarid, int application) {
		int i = (int) em.createQuery(
				"select app.statusId from ScholarshipStatus app where app.scholarshipId=:id and app.applicationNumber=:id1")
				.setParameter("id1", application).setParameter("id", scholarid).getSingleResult();

		ScholarshipStatus sch = em.find(ScholarshipStatus.class, i);
		sch.setStatus("Rejected");
		em.merge(sch);
	}

	@Override
	public boolean isalreadyapplied(int scholarid, int application) {
		boolean id = (long) em.createQuery(
				"select count(app) from ScholarshipStatus app where app.applicationNumber=:application and app.scholarshipId=:scholarid")
				.setParameter("application", application).setParameter("scholarid", scholarid).getSingleResult() >= 1
						? true
						: false;
		System.out.println(id);
		return id;

	}

	@Override
	public List<ScholarshipStatus> getstatusbyId(int application) {
		@SuppressWarnings("unchecked")
		List<ScholarshipStatus> list = em
				.createQuery("select app from ScholarshipStatus app where app.applicationNumber=:application")
				.setParameter("application", application).getResultList();
		return list;
	}

	@Override
	public List<ScholarshipStatus> getStudent() {
		@SuppressWarnings("unchecked")
		List<ScholarshipStatus> list = em.createQuery("select app from ScholarshipStatus app").getResultList();
		return list;
	}

}
