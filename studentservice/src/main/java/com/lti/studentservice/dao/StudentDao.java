package com.lti.studentservice.dao;

import java.util.List;

import com.lti.studentservice.entities.Student;

public interface StudentDao {
	
	public int registerStudent(Student student);
	
	public int loginStudent(String email, String password);
	
	public Student findCustomerbyEmail(String email);
	
	public Student findCustomerbyApplicationNumber(int applicationNumber);
	
	public boolean isStudentPresent(String email);
	
	public List<Student> getStudent(int applicationNumber);
	
	public String password(String email);
}
