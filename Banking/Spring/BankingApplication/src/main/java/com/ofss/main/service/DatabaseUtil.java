package com.ofss.main.service;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseUtil {
    Connection getConnection(String url, String username, String password) throws SQLException;
}
