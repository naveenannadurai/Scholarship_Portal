package com.lti.studentservice.service;

import java.util.List;

import com.lti.studentservice.entities.ScholarshipStatus;
import com.lti.studentservice.entities.Student;
import com.lti.studentservice.entities.StudentDetails;

public interface ServiceInterface {
	
	//Student
	
	public int registerStudent(Student student);
	
	public Student loginStudent(String email,String password);
	
	public int registerDetails(StudentDetails stDe);
	
	public List<Student> getStudent(int applicationNumber);
	
	public List<StudentDetails> getStudentlist(int applicationNumber);
	
	public List<ScholarshipStatus> getStudentstatus();
	
	public List<ScholarshipStatus> getStatus(int applicationNumber);
	
	public int setStatus(ScholarshipStatus status);
	
	public void approve(int scholarid,int applicationid);
	
	public void reject(int scholarid,int applicationid);
	
	public String password(String email);

}
