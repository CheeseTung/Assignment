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
import model.Room;

/**
 *
 * @author chitung
 */
public class RoomDBContext extends DBContext {

    public Room getRoom() {
        try {
            String sql = "SELECT [room_id]\n"
                    + "      ,[room_name]\n"
                    + "  FROM [Room]";
            PreparedStatement stm;
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {                
                Room r = new Room();
                r.setId(rs.getInt("room_id"));
                r.setName(rs.getString("room_name"));
                return r;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
