package com.mp3tagrefactory.dao;

import com.mp3tagrefactory.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 *
 * @author amicu
 */
public class UserDao {
    private Connection con;
    private PreparedStatement stmt1;
    private PreparedStatement stmt2;
    
    public UserDao (Connection con) throws SQLException {
        this.con = con;
        stmt1 = con.prepareStatement("SELECT * FROM users WHERE username = ?");
        stmt2 = con.prepareStatement("INSERT INTO users VALUES(NULL, ?, ?)");
    }
    
    public Optional<User> authenticateUser(User user) throws SQLException {
        User u = null;
        stmt1.setString(1,u.getUsername());
        ResultSet rs = stmt1.executeQuery();
        if (rs.next()) {
            u.setId(rs.getInt("id"));
            u.setUsername(rs.getString("name"));
            u.setPassword(rs.getString("pass"));
        }
        return Optional.ofNullable(u);
    }
    
    public void addUser(User user) throws SQLException {
        User u = null;
        stmt2.setString(1,u.getUsername());
        stmt2.setString(2,u.getPassword());
        stmt2.executeUpdate();
    }
    
    public boolean getUser(String username) throws SQLException {
        boolean result = false;
        stmt1.setString(1, username);
        if (stmt1.executeQuery().next()) {
            result = true;
        }
        return result;
    }
    
    
}
