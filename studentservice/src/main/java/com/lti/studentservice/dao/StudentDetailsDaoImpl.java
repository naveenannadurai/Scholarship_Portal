package com.lti.studentservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lti.studentservice.entities.StudentDetails;

@Service
@Transactional
public class StudentDetailsDaoImpl implements StudentDetailsDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public long registerDetails(StudentDetails student) {

//		System.out.println("Hiii");
		StudentDetails sd = em.merge(student);
		return sd.getRollNo();
	}

	@Override
	public List<StudentDetails> getStudent(int application) {
		String sql = "select app from StudentDetails app where app.student.applicationNumber=:application";

		Query q = em.createQuery(sql).setParameter("application", application);

		@SuppressWarnings("unchecked")
		List<StudentDetails> list = q.getResultList();

		return list;
	}

}
