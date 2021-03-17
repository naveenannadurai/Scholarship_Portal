package com.lti.studentservice.status;

public class LoginStatus extends Status {

	private int applicationNumber;
	
	private String studentFname;
	
	private String studentLname;
	
	private String studentEmail;

	public int getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(int applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getStudentFname() {
		return studentFname;
	}

	public void setStudentFname(String studentFname) {
		this.studentFname = studentFname;
	}

	public String getStudentLname() {
		return studentLname;
	}

	public void setStudentLname(String studentLname) {
		this.studentLname = studentLname;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	
	
}
