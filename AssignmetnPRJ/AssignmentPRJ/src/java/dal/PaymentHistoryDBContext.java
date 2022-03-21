/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bill;
import model.PaymentHistory;

/**
 *
 * @author chitung
 */
public class PaymentHistoryDBContext extends DBContext {

    public void insertPaymentHistory(PaymentHistory ph) {
        String sql = "INSERT INTO [History]\n"
                + "           ([payment_id]\n"
                + "           ,[bill_id]\n"
                + "           ,[room_name]\n"
                + "           ,[roomCharge]\n"
                + "           ,[electricMoney]\n"
                + "           ,[waterMoney]\n"
                + "           ,[networkMoney]\n"
                + "           ,[cleanerMoney]\n"
                + "           ,[waterDrink]\n"
                + "           ,[shortMoney]\n"
                + "           ,[totalPrice]\n"
                + "           ,[fromDate]\n"
                + "           ,[toDate])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, ph.getPayment().getId());
            stm.setInt(2, ph.getBill().getId());
            stm.setString(3, ph.getRoomName());
            stm.setInt(4, ph.getRoomCharge());
            stm.setInt(5, ph.getElectricMoney());
            stm.setInt(6, ph.getWaterMoney());
            stm.setInt(7, ph.getNetworkMoney());
            stm.setInt(8, ph.getCleanerMoney());
            stm.setInt(9, ph.getWaterDrink());
            stm.setInt(10, ph.getShortMoney());
            stm.setInt(11, ph.getTotalPrice());
            stm.setDate(12, ph.getFromDate());
            stm.setDate(13, ph.getToDate());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PaymentHistoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PaymentHistoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(PaymentHistoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PaymentHistoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public ArrayList<PaymentHistory> getPaymentHistory(String fromDate, String toDate) {
        ArrayList<PaymentHistory> paymentHistory = new ArrayList<>();
        try {
            String sql = "SELECT [room_name]\n"
                    + "      ,[roomCharge]\n"
                    + "      ,[electricMoney]\n"
                    + "      ,[waterMoney]\n"
                    + "      ,[networkMoney]\n"
                    + "      ,[cleanerMoney]\n"
                    + "      ,[waterDrink]\n"
                    + "      ,[shortMoney]\n"
                    + "      ,[totalPrice]\n"
                    + "      ,[fromDate]\n"
                    + "      ,[toDate]\n"
                    + "  FROM [History]\n"
                    + "  Where fromDate >= ? And toDate <= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, fromDate);
            stm.setString(2, toDate);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PaymentHistory ph = new PaymentHistory();
                ph.setRoomName(rs.getString("room_name"));
                ph.setRoomCharge(rs.getInt("roomCharge"));
                ph.setElectricMoney(rs.getInt("electricMoney"));
                ph.setWaterMoney(rs.getInt("waterMoney"));
                ph.setNetworkMoney(rs.getInt("networkMoney"));
                ph.setCleanerMoney(rs.getInt("cleanerMoney"));
                ph.setWaterDrink(rs.getInt("waterDrink"));
                ph.setShortMoney(rs.getInt("shortMoney"));
                ph.setTotalPrice(rs.getInt("totalPrice"));
                ph.setFromDate(rs.getDate("fromDate"));
                ph.setToDate(rs.getDate("toDate"));
                paymentHistory.add(ph);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentHistoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paymentHistory;
    }

    public int count(String fromDate, String toDate) {
        try {
            String sql = "SELECT COUNT(*) as Total FROM History WHERE fromDate >= ? And toDate <= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, fromDate);
            stm.setString(2, toDate);
            ResultSet rs = stm.executeQuery();        
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentHistoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
