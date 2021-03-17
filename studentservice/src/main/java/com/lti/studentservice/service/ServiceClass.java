package com.lti.studentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.studentservice.dao.ScholarshipStatusDao;
import com.lti.studentservice.dao.StudentDao;
import com.lti.studentservice.dao.StudentDetailsDao;
import com.lti.studentservice.entities.ScholarshipStatus;
import com.lti.studentservice.entities.Student;
import com.lti.studentservice.entities.StudentDetails;
import com.lti.studentservice.exception.StudentException;

@Service
public class ServiceClass implements ServiceInterface {

	@Autowired
	private StudentDao student;

	@Autowired
	private StudentDetailsDao ssss;

	@Autowired
	private ScholarshipStatusDao std;

	@Override
	public Student loginStudent(String email, String password) {
		try {
			if (!student.isStudentPresent(email))
				throw new StudentException("Student is not there");
			int id = (int) student.loginStudent(email, password);
			if (id == 0) {
				throw new StudentException("Wrong Credentials");
			} else {
				Student studen = student.findCustomerbyEmail(email);
				return studen;
			}

		} catch (EmptyResultDataAccessException e) {
			throw new StudentException("Incorrect email/password");
		}
	}

	@Override
	public int registerStudent(Student s) {
		try {
			if (student.isStudentPresent(s.getEmail()))
				throw new StudentException("Student is already registerd");
			int id = (int) student.registerStudent(s);
			return id;
		} catch (EmptyResultDataAccessException e) {
			throw new StudentException("Error");
		}
	}

	@Override
	public int registerDetails(StudentDetails stDe) {
		System.out.println("Hii");
		int id = (int) ssss.registerDetails(stDe);
		return id;
	}

	@Override
	public List<Student> getStudent(int applicationNumber) {
		List<Student> list = student.getStudent(applicationNumber);
		return list;
	}

	@Override
	public int setStatus(ScholarshipStatus status) {
		try {
			if (std.isalreadyapplied(status.getScholarshipId(), status.getApplicationNumber()))
				throw new StudentException("Already Applied");
			int id = std.registerStatus(status);
			return id;

		} catch (EmptyResultDataAccessException e) {
			throw new StudentException("Error");
		}
	}

	@Override
	public void approve(int scholarid, int applicationid) {

		std.approve(scholarid, applicationid);
	}

	@Override
	public void reject(int scholarid, int applicationid) {

		std.reject(scholarid, applicationid);

	}

	@Override
	public List<ScholarshipStatus> getStatus(int applicationNumber) {
		List<ScholarshipStatus> list = std.getstatusbyId(applicationNumber);
		return list;
	}

	@Override
	public List<ScholarshipStatus> getStudentstatus() {
		List<ScholarshipStatus> list = std.getStudent();
		return list;
	}

	@Override
	public List<StudentDetails> getStudentlist(int applicationNumber) {
		List<StudentDetails> list = ssss.getStudent(applicationNumber);
		return list;
	}

	@Override
	public String password(String email) {
		if(!student.isStudentPresent(email)) {
			throw new StudentException("Student is not there");
			}
  		String password = student.password(email);
		return password;
	
	}
}
