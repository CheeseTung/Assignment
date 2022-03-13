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
import model.Payment;

/**
 *
 * @author chitung
 */
public class PaymentDBContext extends DBContext {

    public Payment getPayment(int payment_id) {

        try {
            String sql = "select (b.room_charge + (eB.[count] * eB.price) + b.network_money + b.water_money + b.cleaner_money + b.water_drink -b.short_money) as totalPrice\n"
                    + " from Payment p inner join Bill b on p.id = b.payment_id\n"
                    + " inner join ElectricBill eB on  eB.bill_id = b.id\n"
                    + "where b.payment_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, payment_id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Payment p = new Payment();
                p.setId(rs.getInt("id"));
                p.setTotalPrice(rs.getInt("totalPrice"));
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
