package com.ofss.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.Login;
import com.ofss.main.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController 
{
    @Autowired
    private LoginService loginService;
    

    @PostMapping("authenticate")
    public String login(@RequestParam String email, @RequestParam String password) {
        Login login = loginService.authenticateUser(email, password);
        
        if (login != null) 
            return "Login successful!";
        
        else
        {
        	loginService.incrementLoginCount(email);
        	Integer loginCount = loginService.getLoginCount(email);
        	System.out.println(loginCount);
        	if(loginCount>=3)
        	{
        		loginService.lockAccount(email);
        		return "Your account has been locked due to too many failed login attempts.";
        	}
        	return "Invalid username or password. Attempts Remaining : "+(3-loginCount);
        	
        }
    }
}
