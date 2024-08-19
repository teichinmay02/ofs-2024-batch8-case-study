package com.ofss.main.domain;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_details")
public class Customer {

    @Id
    @Column(name = "CUST_ID")
    private String custId;
    
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    
    @Column(name = "LAST_NAME")
    private String lastName;
    
    @Column(name = "GENDER")
    private String gender;
    
    @Column(name = "DOB")
    private java.sql.Date dob;
    
    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;
    
    @Column(name = "INCOME")
    private java.math.BigDecimal income;
    
    @Column(name = "OCCUPATION")
    private String occupation;
    
    @Column(name = "CIBIL_SCORE")
    private java.math.BigDecimal cibilScore;
    
    @Column(name = "MOBILE_NO")
    private Long mobileNo;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "ADDRESS")
    private String address;
    
    @Column(name = "STATUS")
    private Boolean status;
    
    public Customer() {}

	public Customer(String custId, String firstName, String middleName, String lastName, String gender, Date dob,
			String maritalStatus, BigDecimal income, String occupation, BigDecimal cibilScore, Long mobileNo,
			String email, String address, Boolean status) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.maritalStatus = maritalStatus;
		this.income = income;
		this.occupation = occupation;
		this.cibilScore = cibilScore;
		this.mobileNo = mobileNo;
		this.email = email;
		this.address = address;
		this.status = status;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public java.sql.Date getDob() {
		return dob;
	}

	public void setDob(java.sql.Date dob) {
		this.dob = dob;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public java.math.BigDecimal getIncome() {
		return income;
	}

	public void setIncome(java.math.BigDecimal income) {
		this.income = income;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public java.math.BigDecimal getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(java.math.BigDecimal cibilScore) {
		this.cibilScore = cibilScore;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", gender=" + gender + ", dob=" + dob + ", maritalStatus=" + maritalStatus + ", income="
				+ income + ", occupation=" + occupation + ", cibilScore=" + cibilScore + ", mobileNo=" + mobileNo
				+ ", email=" + email + ", address=" + address + ", status=" + status + "]";
	}

    
    

}
