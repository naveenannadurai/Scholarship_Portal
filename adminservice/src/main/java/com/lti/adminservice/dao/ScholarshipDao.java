package com.lti.adminservice.dao;

import java.util.List;

import com.lti.adminservice.entities.Scholarship;

public interface ScholarshipDao {
	
	public int registerScholarship(Scholarship scholar);
	
	public List<Scholarship> getScholarship();
	
	public void delete(int id);
}
