package com.lti.adminservice.dao;

import com.lti.adminservice.entities.Admin;

public interface AdminDao {

	public String registerAdmin(Admin admin);
	
	public String loginAdmin(String email,String password);
	
	public boolean isAdminPresent(String email);
	
	public Admin findAdminByEmail(String email);
	
	public String password(String email);
}
