package com.lti.adminservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.adminservice.entities.Admin;
import com.lti.adminservice.entities.Scholarship;
import com.lti.adminservice.exception.StudentException;
import com.lti.adminservice.service.AdminServiceInterface;
import com.lti.adminservice.status.AdminLoginStatus;
import com.lti.adminservice.status.RegisterStatus;
import com.lti.adminservice.status.Status;
import com.lti.adminservice.status.Status.StatusType;

@RestController
@CrossOrigin
public class AdminController {

	@Autowired
	private AdminServiceInterface service;
	
	@PostMapping("/registerAdmin")
	public Status registerAdmin(@RequestBody Admin ad) {
		try {
			String Name = service.registerAdmin(ad);
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.SUCCESS);
			status.setName(Name);
			status.setMessage("Registration Sucessful");
			return status;
		}catch (StudentException e)
		{
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	@PostMapping("/adminLogin")
	public Status studentLogin(@RequestBody Admin ad) {
		try {
			Admin st = service.loginAdmin(ad.getEmail(),ad.getPassword());
			System.out.println(st);
			AdminLoginStatus status = new AdminLoginStatus();
			status.setName(st.getName());
			status.setEmail(st.getEmail());
			status.setContact(st.getContact());
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Login Successful");
			return status;
		}catch (StudentException e) {
			AdminLoginStatus loginStatus = new AdminLoginStatus();
			loginStatus.setMessage(e.getMessage());
			loginStatus.setStatus(StatusType.FAILURE);
			return loginStatus;
		}
	}
	
	@PostMapping("/registerScholarship")
	public Status registerScholarship(@RequestBody Scholarship sc) {
		try {
			int id = service.registerScholarship(sc);
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.SUCCESS);
			status.setScholarshipId(id);
			status.setMessage("Scholarship Added Sucessfully");
			return status;
		}catch (StudentException e)
		{
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	@PostMapping("/forgot")
	public Status forgotpass(@RequestBody Admin ad) {
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
	
	@GetMapping("/getScholarshipList")
	public List<Scholarship> getScholarshipList(){
		List<Scholarship> list = service.getList();
		return list;
	}
	
	
	@GetMapping("/hello")
	public String getstring() {
		return "Kumar";
	}
	
	@DeleteMapping("/delete/{scholarid}")
	public Status delete(@PathVariable(name = "scholarid") int sid) {
		try {
			service.delete(sid);
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Deleted Sucessful");
			return status;
		}catch (StudentException e)
		{
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
}
