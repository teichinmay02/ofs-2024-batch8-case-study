package com.ofss.main.service;

import com.ofss.main.domain.Login;

public interface LoginService {
    Login createNewLogin(Login login);
    //Login validateLogin(String email, String password);
    Login validateLogin(Login login);
    boolean login(int login_id, String password);
}