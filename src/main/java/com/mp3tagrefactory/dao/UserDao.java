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
    
    public boolean authenticateUser(User user) throws SQLException {
        boolean result = false;
        stmt1.setString(1,user.getUsername());
        ResultSet rs = stmt1.executeQuery();
        if (rs.next()) {
            if (rs.getString("password").equals(user.getPassword())){
                result = true;
            }
        }
        return result;
    }
    
    public boolean addUser(User user) throws SQLException {
        boolean result = false;
        if (!getUser(user.getUsername()).isPresent()) {
            stmt2.setString(1,user.getUsername());
            stmt2.setString(2,user.getPassword());
            stmt2.executeUpdate();
            result = true;
        }
        return result;
    }
    
    public Optional<User> getUser(String username) throws SQLException {
        User user = new User();
        stmt1.setString(1, username);
        ResultSet rs = stmt1.executeQuery();
        if (rs.next()) {
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setId(rs.getInt("id"));
        }
        return Optional.ofNullable(user);
    }
    
    
}
