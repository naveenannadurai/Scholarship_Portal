package com.lti.studentservice.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@SequenceGenerator(name = "application", initialValue = 45985456, allocationSize = 146)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application")
	private int applicationNumber;

	private String firstName;
	private String lastName;
	public Gender gender;

	@Column(unique = true)
	private String email;

	private String city;
	private String state;
	private String country;
	private int pincode;

	private String password;
	private Date birth;

	@OneToOne(mappedBy = "student")
	private StudentDetails studentDetails;

	public enum Gender {
		Male, Female, Transgender
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int applicationNumber, String firstName, String lastName, Gender gender, String email, String city,
			String state, String country, int pincode, String password, Date birth) {
		super();
		this.applicationNumber = applicationNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.password = password;
		this.birth = birth;
	}

	public int getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(int applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "Student [applicationNumber=" + applicationNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", email=" + email + ", city=" + city + ", state=" + state + ", country="
				+ country + ", pincode=" + pincode + ", password=" + password + ", birth=" + birth + "]";
	}

}
