package com.ofss.main.service;

import com.ofss.main.domain.Admin;

public interface AdminService {
    Admin validateAdminLogin(Admin admin);
    boolean approveCustomer(int customerId);
}
