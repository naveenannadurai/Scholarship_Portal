package com.lti.studentservice.dao;

import java.util.List;

import com.lti.studentservice.entities.ScholarshipStatus;

public interface ScholarshipStatusDao {

	public int registerStatus(ScholarshipStatus status);
	
	public void approve(int scholarid, int application);
	
	public void reject(int scholarid, int application);
	
	public boolean isalreadyapplied(int scholarid, int application);
	
	public List<ScholarshipStatus> getstatusbyId(int application);
	
	public List<ScholarshipStatus> getStudent();
}
