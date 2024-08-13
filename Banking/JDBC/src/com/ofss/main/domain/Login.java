package com.ofss.main.domain;

public class Login {
    private int customerId;
    private int loginId;
    private String password;
    private int loginAttempts;
    private String loginStatus;
    private String email;

    public Login() {

    }

    public Login(String password) {
        this.password = password;
    }

    public Login(int loginId, String password, int loginAttempts, String loginStatus) {
        this.loginId = loginId;
        this.password = password;
        this.loginAttempts = loginAttempts;
        this.loginStatus = loginStatus;
    }

    // Constructor with required fields for login validation
    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getLoginId() {
        return loginId;
    }
    // public void getConnection()
    // {
    //     return ;
    // }



    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getEmail() {
        // TODO Auto-generated method stub
       return email;
    }


    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public int getCustomerId() {
        return customerId;
    }

    public void setEmail(String email) {
        // TODO Auto-generated method stub
        this.email = email;
    }

    @Override
    public String toString() {
        return "Login [customerId=" + customerId + ", loginId=" + loginId + ", password=" + password
                + ", loginAttempts=" + loginAttempts + ", loginStatus=" + loginStatus + ", email=" + email + "]";
    }

    // public String getEmail()
    // {
    //     return email;
    // }

    // public void setCustomerId(int customerId) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'setCustomerId'");
    // }


}
