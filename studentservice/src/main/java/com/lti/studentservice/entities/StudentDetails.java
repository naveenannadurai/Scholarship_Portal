package com.lti.studentservice.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class StudentDetails {

	@Id
	private long rollNo;
	private String institute;
	private String course;
	private int year;
	private String modeOfStudy;
	private double cgpa;
	
	private String religion;
	private String community;
	private String stay;
	
	private long aadhar;
	private long phone;
	private long income;
	
	private String fatherName;
	private String motherName;
	
	private String sslcExamName;
	private double sslcPercentage;
	private int sslcPassingYear;
	private long sslcRollno;
	
	private String hscExamName;
	private double hscPercentage;
	private int hscPassingYear;
	private long hscRollno;
	
	private boolean isOrphan;
	private boolean isDisabled;
	private int disabledpercentage;
	
	private String maritalStatus;
	private String parentProfession;
	
	private String ifsc;
	private long accountNumber;
	
	@OneToOne
	@JoinColumn(name="applicationNumber",nullable = false,unique = true)
	private Student student;
	
	public StudentDetails() {
		// TODO Auto-generated constructor stub
	}



	public StudentDetails(long rollNo, String institute, String course, int year, String modeOfStudy, double cgpa,
			String religion, String community, String stay, long aadhar, long phone, long income, String fatherName,
			String motherName, String sslcExamName, double sslcPercentage, int sslcPassingYear, long sslcRollno,
			String hscExamName, double hscPercentage, int hscPassingYear, long hscRollno, boolean isOrphan,
			boolean isDisabled, int disabledpercentage, String maritalStatus, String parentProfession, String ifsc,
			long accountNumber, Student student) {
		super();
		this.rollNo = rollNo;
		this.institute = institute;
		this.course = course;
		this.year = year;
		this.modeOfStudy = modeOfStudy;
		this.cgpa = cgpa;
		this.religion = religion;
		this.community = community;
		this.stay = stay;
		this.aadhar = aadhar;
		this.phone = phone;
		this.income = income;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.sslcExamName = sslcExamName;
		this.sslcPercentage = sslcPercentage;
		this.sslcPassingYear = sslcPassingYear;
		this.sslcRollno = sslcRollno;
		this.hscExamName = hscExamName;
		this.hscPercentage = hscPercentage;
		this.hscPassingYear = hscPassingYear;
		this.hscRollno = hscRollno;
		this.isOrphan = isOrphan;
		this.isDisabled = isDisabled;
		this.disabledpercentage = disabledpercentage;
		this.maritalStatus = maritalStatus;
		this.parentProfession = parentProfession;
		this.ifsc = ifsc;
		this.accountNumber = accountNumber;
		this.student = student;
	}



	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getStay() {
		return stay;
	}

	public void setStay(String stay) {
		this.stay = stay;
	}

	public long getAadhar() {
		return aadhar;
	}

	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public long getIncome() {
		return income;
	}

	public void setIncome(long income) {
		this.income = income;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public long getRollNo() {
		return rollNo;
	}

	public void setRollNo(long rollNo) {
		this.rollNo = rollNo;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getModeOfStudy() {
		return modeOfStudy;
	}

	public void setModeOfStudy(String modeOfStudy) {
		this.modeOfStudy = modeOfStudy;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public String getSslcExamName() {
		return sslcExamName;
	}

	public void setSslcExamName(String sslcExamName) {
		this.sslcExamName = sslcExamName;
	}

	public double getSslcPercentage() {
		return sslcPercentage;
	}

	public void setSslcPercentage(double sslcPercentage) {
		this.sslcPercentage = sslcPercentage;
	}

	public int getSslcPassingYear() {
		return sslcPassingYear;
	}

	public void setSslcPassingYear(int sslcPassingYear) {
		this.sslcPassingYear = sslcPassingYear;
	}

	public long getSslcRollno() {
		return sslcRollno;
	}

	public void setSslcRollno(long sslcRollno) {
		this.sslcRollno = sslcRollno;
	}

	public String getHscExamName() {
		return hscExamName;
	}

	public void setHscExamName(String hscExamName) {
		this.hscExamName = hscExamName;
	}

	public double getHscPercentage() {
		return hscPercentage;
	}

	public void setHscPercentage(double hscPercentage) {
		this.hscPercentage = hscPercentage;
	}

	public int getHscPassingYear() {
		return hscPassingYear;
	}

	public void setHscPassingYear(int hscPassingYear) {
		this.hscPassingYear = hscPassingYear;
	}

	public long getHscRollno() {
		return hscRollno;
	}

	public void setHscRollno(long hscRollno) {
		this.hscRollno = hscRollno;
	}

	public boolean isOrphan() {
		return isOrphan;
	}

	public void setOrphan(boolean isOrphan) {
		this.isOrphan = isOrphan;
	}

	public boolean isDisabled() {
		return isDisabled;
	}

	public void setDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	public int getDisabledpercentage() {
		return disabledpercentage;
	}

	public void setDisabledpercentage(int disabledpercentage) {
		this.disabledpercentage = disabledpercentage;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getParentProfession() {
		return parentProfession;
	}

	public void setParentProfession(String parentProfession) {
		this.parentProfession = parentProfession;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}



	@Override
	public String toString() {
		return "StudentDetails [rollNo=" + rollNo + ", institute=" + institute + ", course=" + course + ", year=" + year
				+ ", modeOfStudy=" + modeOfStudy + ", cgpa=" + cgpa + ", religion=" + religion + ", community="
				+ community + ", stay=" + stay + ", aadhar=" + aadhar + ", phone=" + phone + ", income=" + income
				+ ", fatherName=" + fatherName + ", motherName=" + motherName + ", sslcExamName=" + sslcExamName
				+ ", sslcPercentage=" + sslcPercentage + ", sslcPassingYear=" + sslcPassingYear + ", sslcRollno="
				+ sslcRollno + ", hscExamName=" + hscExamName + ", hscPercentage=" + hscPercentage + ", hscPassingYear="
				+ hscPassingYear + ", hscRollno=" + hscRollno + ", isOrphan=" + isOrphan + ", isDisabled=" + isDisabled
				+ ", disabledpercentage=" + disabledpercentage + ", maritalStatus=" + maritalStatus
				+ ", parentProfession=" + parentProfession + ", ifsc=" + ifsc + ", accountNumber=" + accountNumber
				+ ", student=" + student + "]";
	}
	
	
}
