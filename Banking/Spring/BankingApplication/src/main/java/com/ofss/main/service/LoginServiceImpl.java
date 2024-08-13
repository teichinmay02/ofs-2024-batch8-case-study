package com.ofss.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Login;
import com.ofss.main.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Login authenticateUser(String email, String password) {
        Login login = loginRepository.findbyEmail(email);
        if (login != null && login.getPassword().equals(password) ) {
            return login;
        }
        return null;
    }

    @Override
    public void incrementLoginCount(String email) {
        Login login = loginRepository.findbyEmail(email);
        if (login != null) {
            login.setLoginCount(login.getLoginCount() + 1);
            loginRepository.save(login);
            
        }
    }
    

    @Override
    public Integer getLoginCount(String email) {
        Login login = loginRepository.findbyEmail(email);
        if (login != null) {
            return login.getLoginCount();
        }
        return null;
    }


    @Override
    public void lockAccount(String email) {
        Login login = loginRepository.findbyEmail(email);
        if (login != null) {
            login.setStatus("locked");
            loginRepository.save(login);
        }
    }

}
