package com.ofss.main.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "login_details")
public class Login {

    @Id
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "login_count")
    private Integer loginCount;
    
    @Column(name = "locked_status")
    private boolean status;
    
    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    public Login() {}

    
    
	public Login(String email, String password, Integer loginCount, boolean status, Customer customer) {
		super();
		this.email = email;
		this.password = password;
		this.loginCount = loginCount;
		this.status = status;
		this.customer = customer;
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

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + password + ", loginCount=" + loginCount + ", status=" + status
				+ ", customer=" + customer + "]";
	}
    
  





}
