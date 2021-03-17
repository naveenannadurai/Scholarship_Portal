package com.lti.adminservice.service;

import java.util.List;

import com.lti.adminservice.entities.Admin;
import com.lti.adminservice.entities.Scholarship;

public interface AdminServiceInterface {

	
	public String registerAdmin(Admin admin);
	
	public Admin loginAdmin(String email,String Password);
	
	public int registerScholarship(Scholarship scholar);
	
	public List<Scholarship> getList();
	
	public void delete(int id);
	
	public String password(String email);
}
