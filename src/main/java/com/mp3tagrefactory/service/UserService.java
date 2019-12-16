package com.mp3tagrefactory.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author amicu
 */
public class UserService {
    private Connection con;
    private String url = "jdbc:mysql://localhost/tagrefactorydb";
    private String user = "deskapp";
    private String pass = "";
    
    private UserService() {
        try {
            con = DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static final class SingletonHolder {
        static final UserService SINGLETON = new UserService();
    }
    
    public static UserService getInstance() {
        return SingletonHolder.SINGLETON;
    }
    
    public Connection getConnection () {
        return this.con;
    }
}
