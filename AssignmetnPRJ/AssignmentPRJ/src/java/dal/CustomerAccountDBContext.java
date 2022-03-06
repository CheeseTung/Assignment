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
import model.customerAccount;

/**
 *
 * @author chitung
 */
public class CustomerAccountDBContext extends DBContext {

    public customerAccount getCustomerAccount(String username, String password) {
        try {
            String sql = "SELECT username,password,displayname,number,address,dob FROM CustomerAccount WHERE username = ? AND password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                customerAccount ca = new customerAccount();
                ca.setUsername(rs.getString("username"));
                ca.setPassword(rs.getString("password"));
                ca.setDisplayname(rs.getString("displayname"));
                ca.setNumber(rs.getString("number"));;
                ca.setAddress(rs.getString("address"));
                ca.setDob(rs.getDate("dob"));
                return ca;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HostAccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertCustomerAccount(customerAccount ca) {
        String sql = "INSERT INTO [dbo].[CustomerAccount]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[displayname]\n"
                + "           ,[number]\n"
                + "           ,[address])\n"
                + "     VALUES\n"
                + "           (?,\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
                PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, ca.getUsername());
            stm.setString(2, ca.getPassword());
            stm.setString(3, ca.getDisplayname());
            stm.setString(4, ca.getNumber());
            stm.setString(5, ca.getAddress());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerAccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
                finally
        {
            if(stm != null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerAccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection !=null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerAccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
