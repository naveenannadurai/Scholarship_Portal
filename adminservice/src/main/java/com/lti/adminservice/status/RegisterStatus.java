package com.lti.adminservice.status;

public class RegisterStatus extends Status {

	private int applicationNumber;
	
	private String Name;
	
	private int scholarshipId;

	public int getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(int applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getScholarshipId() {
		return scholarshipId;
	}

	public void setScholarshipId(int scholarshipId) {
		this.scholarshipId = scholarshipId;
	}



}
