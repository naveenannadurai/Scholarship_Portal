package com.lti.adminservice.status;

public class AdminLoginStatus extends Status{
	
	private String Name;
	
	private String email;
	
	private long contact;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}
	
	

}
