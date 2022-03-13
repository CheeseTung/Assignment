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
import model.Contract;
import model.Room;

/**
 *
 * @author chitung
 */
public class ContractDBContext extends DBContext {

    public Contract getContract(String roomName) {
        try {
            String sql = "Select c.id,c.deposit,c.hire,r.room_id \n"
                    + "from Contract c inner join Room r on c.room_id = r.room_id\n"
                    + "where r.room_name = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, roomName);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {                
                Contract c = new Contract();
                c.setId(rs.getInt("id"));
                c.setDeposit(rs.getInt("deposit"));
                c.setHire(rs.getDate("hire"));
                Room r = new Room();
                r.setId(rs.getInt("room_id"));
                c.setRoom(r);
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContractDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
