/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.hostAccount;

/**
 *
 * @author chitung
 */
public class HostAccountDBContext extends DBContext{
    public hostAccount getHostAccount(String username, String password){
        try {
            String sql = "SELECT username,password,displayname FROM HostAccount WHERE username = ? AND password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                hostAccount ha = new hostAccount();
                ha.setUsername(rs.getString("username"));
                ha.setPassword(rs.getString("password"));
                ha.setDisplayname(rs.getString("displayname"));
                return ha;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HostAccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
