package com.lti.adminservice.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	
	
	private String name;
	@Id
	private String email;
	
	private String password;
	
	private long contact;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String name, String email, String password, long contact) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.contact = contact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + ", email=" + email + ", password=" + password + ", contact=" + contact + "]";
	}
	
	
}
