package com.lti.studentservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.studentservice.dao.StudentDaoImpl;
import com.lti.studentservice.entities.ScholarshipStatus;
import com.lti.studentservice.entities.Student;
import com.lti.studentservice.entities.StudentDetails;
import com.lti.studentservice.exception.StudentException;
import com.lti.studentservice.service.ServiceInterface;
import com.lti.studentservice.status.LoginStatus;
import com.lti.studentservice.status.RegisterStatus;
import com.lti.studentservice.status.Status;
import com.lti.studentservice.status.Status.StatusType;

@RestController
@CrossOrigin
public class StudentController {

	@Autowired
	private ServiceInterface service;

	@Autowired
	private StudentDaoImpl sttt;

	@PostMapping("/registerStudent")
	public Status addStudent(@RequestBody Student stud) {
		try {
			int id = service.registerStudent(stud);
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.SUCCESS);
			status.setApplicationNumber(id);
			status.setMessage("Registration Sucessful");
			return status;
		} catch (StudentException e) {
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}

	@PostMapping("/studentLogin")
	public Status studentLogin(@RequestBody Student stu) {
		try {
			Student st = service.loginStudent(stu.getEmail(), stu.getPassword());
			LoginStatus status = new LoginStatus();
			status.setApplicationNumber(st.getApplicationNumber());
			status.setStudentFname(st.getFirstName());
			status.setStudentLname(st.getLastName());
			status.setStudentEmail(st.getEmail());
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Login Successful");
			return status;
		} catch (StudentException e) {
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setMessage(e.getMessage());
			loginStatus.setStatus(StatusType.FAILURE);
			return loginStatus;
		}
	}

	@GetMapping("/getStatus/{applicationNo}")
	public List<ScholarshipStatus> getStatus(@PathVariable(name = "applicationNo") int app) {
		List<ScholarshipStatus> list = service.getStatus(app);
		return list;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/getstudent/{applicationNo}")
	public List<StudentDetails> getDetails(@PathVariable(name = "applicationNo") int app) {
		List<Student> list1 = service.getStudent(app);
		List<StudentDetails> list2 = service.getStudentlist(app);
		List list = new ArrayList();
		list.add(list1);
		list.add(list2);
		return list;
	}

	@GetMapping("/getstudentList")
	public List<ScholarshipStatus> getStudent() {
		List<ScholarshipStatus> list = service.getStudentstatus();
		return list;
	}

	@PostMapping("/registerDetails/{applicationNo}")
	public Status registerDetails(@RequestBody StudentDetails sd, @PathVariable(name = "applicationNo") int no) {
		try {
			System.out.println(no);

			StudentDetails stden = sd;
			System.out.println(stden);
			Student studd = sttt.findCustomerbyApplicationNumber(no);
			sd.setStudent(studd);
			System.out.println(sd);
			int acc = service.registerDetails(sd);
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.SUCCESS);
			status.setApplicationNumber(acc);
			status.setMessage("Registration Sucessful");
			return status;
		} catch (Exception e) {
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}

	@PostMapping("/forgot")
	public Status forgotpass(@RequestBody Student ad) {
		try {
			String email = service.password(ad.getEmail());
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.SUCCESS);
			status.setName(email);
			status.setMessage("Password found");
			return status;
			
		}catch (Exception e) {
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	@PostMapping("/setStatus")
	public Status setStatus(@RequestBody ScholarshipStatus state) {
		try {
			state.setStatus("inprogress");
			int id = service.setStatus(state);
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.SUCCESS);
			status.setApplicationNumber(id);
			status.setMessage("Scholarship Applied Sucessfully");
			return status;
		} catch (StudentException e) {
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}

	@PutMapping("/approve")
	public void setapproval(@RequestBody ScholarshipStatus status) {
		service.approve(status.getScholarshipId(), status.getApplicationNumber());
	}

	@PutMapping("/reject")
	public void setrejectall(@RequestBody ScholarshipStatus status) {
		service.reject(status.getScholarshipId(), status.getApplicationNumber());
	}
	
	@GetMapping("/hello")
	public String getstring() {
		return "Kumar";
	}

}