package com.lti.adminservice.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lti.adminservice.entities.Admin;


@Service
@Transactional
public class AdminDaoImpl implements AdminDao {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public String registerAdmin(Admin admin) {
		Admin at = em.merge(admin);;
		return at.getName();
	}

	@Override
	public String loginAdmin(String email, String password) {
		try {
			return (String)em.createQuery("select a.name from Admin a where a.email=:email and a.password=:pw")
					.setParameter("email", email).setParameter("pw", password).getSingleResult();
		}catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean isAdminPresent(String email) {
		return (long) em.createQuery("select count (a.email) from Admin a where a.email=:email")
				.setParameter("email", email).getSingleResult() == 1? true : false;
	}

	@Override
	public Admin findAdminByEmail(String email1) {
		String email = (String) em.createQuery("select a.email from Admin a where a.email=:email")
				.setParameter("email", email1).getSingleResult();
		return em.find(Admin.class, email);
	}

	@Override
	public String password(String email) {
		Admin a = em.find(Admin.class, email);
		return a.getPassword();
	}

}
