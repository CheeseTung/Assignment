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
import model.Bill;
import model.ElectricBill;
import model.Room;

/**
 *
 * @author chitung
 */
public class ElectricDBContext extends DBContext {

    public ArrayList<ElectricBill> getElectricBills() {
        ArrayList<ElectricBill> e = new ArrayList<>();
        try {
            String sql = "SELECT eb.[id]\n"
                    + "  ,eb.[price]\n"
                    + "  ,eb.[count]\n"
                    + "  ,eb.[bill_id],r.room_name\n"
                    + "  FROM [dbo].[ElectricBill] eb inner join Bill b on eb.bill_id = b.id\n"
                    + "  inner join Room r on r.room_id = b.room_id";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ElectricBill eB = new ElectricBill();
                eB.setId(rs.getInt("id"));
                eB.setPrice(rs.getInt("price"));
                eB.setCount(rs.getInt("count"));
                Room r = new Room();
                r.setName(rs.getString("room_name"));
                Bill b = new Bill();
                b.setId(rs.getInt("bill_id"));
                b.setRoom(r);
                eB.setBill(b);
                e.add(eB);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ElectricDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    public ElectricBill getElectricBill(int electricID) {
        String sql = "SELECT eb.[id]\n"
                + ",eb.[price]\n"
                + ",eb.[count]\n"
                + ",eb.[bill_id],r.room_name\n"
                + "FROM [dbo].[ElectricBill] eb inner join Bill b on eb.bill_id = b.id\n"
                + "inner join Room r on r.room_id = b.room_id\n"
                + "WHERE eb.id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, electricID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                ElectricBill eb = new ElectricBill();
                eb.setId(rs.getInt("id"));
                eb.setPrice(rs.getInt("price"));
                eb.setCount(rs.getInt("count"));
                Room r = new Room();
                r.setName(rs.getString("room_name"));
                Bill b = new Bill();
                b.setId(rs.getInt("bill_id"));
                b.setRoom(r);
                eb.setBill(b);
                return eb;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ElectricDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void updateElectric(ElectricBill eb) {
        String sql = "UPDATE [ElectricBill]\n"
                + "   SET[count] = ?\n"
                + " WHERE id = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, eb.getCount());
            stm.setInt(2, eb.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ElectricDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void updateCount() {
        String sql = "UPDATE [dbo].[ElectricBill]\n"
                + "   SET \n"
                + "      [count] = ?\n"
                + " WHERE ElectricBill.bill_id = ?";
    }
}
