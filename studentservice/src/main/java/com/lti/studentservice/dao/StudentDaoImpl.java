package com.lti.studentservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.lti.studentservice.entities.Student;

@Service
@Transactional
public class StudentDaoImpl implements StudentDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public int registerStudent(Student student) {
		Student st = em.merge(student);
		return st.getApplicationNumber();
	}

	@Override
	public int loginStudent(String email, String password) {
		try {
			return (Integer)em.createQuery("select a.applicationNumber from Student a where a.email=:email and a.password=:pw")
					.setParameter("email", email).setParameter("pw", password).getSingleResult();
		}catch (Exception e) {
			return 0;
		}
		
	}

	@Override
	public Student findCustomerbyEmail(String email) {
		int id = (int) em.createQuery("select a.applicationNumber from Student a where a.email=:email")
				.setParameter("email", email).getSingleResult();
		return em.find(Student.class, id);
	}

	@Override
	public Student findCustomerbyApplicationNumber(int applicationNumber) {
		int id = (int) em.createQuery("select a.applicationNumber from Student a where a.applicationNumber=:appno")
				.setParameter("appno", applicationNumber).getSingleResult();
		return em.find(Student.class, id);
	}

	@Override
	public boolean isStudentPresent(String email) {
		
		return (long) em.createQuery("select count (a.email) from Student a where a.email=:email")
				.setParameter("email", email).getSingleResult() == 1? true : false;
	}

	@Override
	public List<Student> getStudent(int application) {
		
		String sql = "select app from Student app where applicationNumber=:application";
		
		Query q = em.createQuery(sql).setParameter("application", application);
		
		@SuppressWarnings("unchecked")
		List<Student> list = q.getResultList();
		
		return list;
	}

	@Override
	public String password(String email) {
		
		int id = (int) em.createQuery("select a.applicationNumber from Student a where a.email=:appno")
				.setParameter("appno", email).getSingleResult();
		Student a = em.find(Student.class, id);
		return a.getPassword();
	}

}
