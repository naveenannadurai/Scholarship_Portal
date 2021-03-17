package com.lti.studentservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class ScholarshipStatus {

	@Id
	@SequenceGenerator(name = "gen", initialValue = 400, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen")
	private int statusId;
	
	private int scholarshipId;
	
	private int applicationNumber;
	
	private String status;

	public ScholarshipStatus() {
		// TODO Auto-generated constructor stub
	}
	
	public ScholarshipStatus(int statusId, int scholarshipId, int applicationNumber, String status) {
		super();
		this.statusId = statusId;
		this.scholarshipId = scholarshipId;
		this.applicationNumber = applicationNumber;
		this.status = status;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getScholarshipId() {
		return scholarshipId;
	}

	public void setScholarshipId(int scholarshipId) {
		this.scholarshipId = scholarshipId;
	}

	public int getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(int applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
