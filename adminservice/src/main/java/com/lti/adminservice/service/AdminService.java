package com.lti.adminservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.adminservice.dao.AdminDao;
import com.lti.adminservice.dao.ScholarshipDao;
import com.lti.adminservice.entities.Admin;
import com.lti.adminservice.entities.Scholarship;
import com.lti.adminservice.exception.StudentException;

@Service
public class AdminService implements AdminServiceInterface {

	@Autowired
	private AdminDao ads;
	
	@Autowired
	private ScholarshipDao sch;
	
	@Override
	public String registerAdmin(Admin admin) {
		String name = ads.registerAdmin(admin);
		return name;
	}

	@Override
	public Admin loginAdmin(String email, String password) {
		try {
			if(!ads.isAdminPresent(email))
				throw new StudentException("Admin is not there");
			String id = ads.loginAdmin(email, password);
			if(id==null ) {
				throw new StudentException("Wrong Credentials");
			}
			else
			{
				Admin adss = ads.findAdminByEmail(email);
				return adss;
			}
			
		}catch (EmptyResultDataAccessException e) {
			throw new StudentException("Incorrect email/password");
		}
	}

	@Override
	public int registerScholarship(Scholarship scholar) {
		int id = sch.registerScholarship(scholar);
		return id;
	}

	@Override
	public List<Scholarship> getList() {
		List<Scholarship> list = sch.getScholarship();
		return list;
	}

	@Override
	public void delete(int id) {
		sch.delete(id);
		
	}

	@Override
	public String password(String email) {
			if(!ads.isAdminPresent(email)) {
				throw new StudentException("Admin is not there");
				}
      		String password = ads.password(email);
			return password;
		
	}

}
