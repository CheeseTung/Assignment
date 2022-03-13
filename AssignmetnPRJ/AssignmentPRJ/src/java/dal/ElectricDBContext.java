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
import model.Bill;
import model.ElectricBill;

/**
 *
 * @author chitung
 */
public class ElectricDBContext extends DBContext {

    public ElectricBill getElectricBill(int billID) {
        try {
            String sql = "SELECT e.[id]\n"
                    + "      ,e.[price]\n"
                    + "      ,e.[count]\n"
                    + "      ,e.bill_id\n"
                    + "  FROM [ElectricBill] e inner join Bill b on e.bill_id = b.id\n"
                    + "  WHERE e.bill_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, billID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                ElectricBill eB = new ElectricBill();
                eB.setId(rs.getInt("id"));
                eB.setPrice(rs.getInt("price"));
                eB.setCount(rs.getInt("count"));
                Bill b = new Bill();
                b.setId(rs.getInt("bill_id"));
                eB.setBill(b);
                return eB;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ElectricDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
                ElectricDBContext eDB = new ElectricDBContext();
                ElectricBill e = eDB.getElectricBill(1);
                System.out.println(e.getPrice());
    }
    public void updateCount() {

    }
}
