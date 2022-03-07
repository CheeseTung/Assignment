/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Notification;

/**
 *
 * @author chitung
 */
public class NotificationDBContext extends DBContext {

    public ArrayList<Notification> getNotification() {
        ArrayList<Notification> alerts = new ArrayList();
        try {
            String sql = "SELECT [alert]\n"
                    + "  FROM [Notification]";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Notification n = new Notification();
                n.setAlert(rs.getString("alert"));
                alerts.add(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotificationDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alerts;
    }

    public void updateNotification(Notification n) {
        String sql = "UPDATE [Notificaiton]\n"
                + "   SET [alert] = ?\n"
                + " WHERE id = 1";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, n.getAlert());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NotificationDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NotificationDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NotificationDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
