package com.lti.studentservice.dao;

import java.util.List;

import com.lti.studentservice.entities.StudentDetails;

public interface StudentDetailsDao {

	public long registerDetails(StudentDetails student);
	
	public List<StudentDetails> getStudent(int applicationNumber);
}
