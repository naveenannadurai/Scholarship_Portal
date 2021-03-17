package com.lti.adminservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Scholarship {

	@Id
	@SequenceGenerator(name = "gen", initialValue = 400, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen")
	private int scholarshipid;
	
	private String name;
	
	private String description;
	
	private String provider;
	
	private int amount;
	
	private String requirements;
	
	public Scholarship() {
		// TODO Auto-generated constructor stub
	}

	public Scholarship(int scholarshipid, String name, String description, String provider, int amount,
			String requirements) {
		super();
		this.scholarshipid = scholarshipid;
		this.name = name;
		this.description = description;
		this.provider = provider;
		this.amount = amount;
		this.requirements = requirements;
	}
	
	public int getScholarshipid() {
		return scholarshipid;
	}

	public void setScholarshipid(int scholarshipid) {
		this.scholarshipid = scholarshipid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	 
}
