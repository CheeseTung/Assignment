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
import model.Payment;
import model.Room;

/**
 *
 * @author chitung
 */
public class BillDBContext extends DBContext {

    public ArrayList<Bill> getBills() {
        ArrayList<Bill> bill = new ArrayList<>();
        try {
            String sql = "SELECT b.[id]\n"
                    + ",b.[room_id]\n"
                    + ",b.payment_id\n"
                    + ",r.[room_name]\n"
                    + ",b.[room_charge]\n"
                    + ",(eb.[count]*eb.price) as electric_money\n"
                    + ",b.[water_money]\n"
                    + ",b.[network_money]\n"
                    + ",b.[cleaner_money]\n"
                    + ",b.[water_drink]\n"
                    + ",b.[status]\n"
                    + ",b.[short_money]\n"
                    + ",b.[fromDate]\n"
                    + ",b.[toDate]\n"
                    + ",(b.room_charge + (eB.[count] * eB.price) + b.network_money + b.water_money + b.cleaner_money + b.water_drink + b.short_money) as totalPrice\n"
                    + "FROM [Bill] b inner join Room r on b.room_id = r.room_id\n"
                    + "inner join Payment p on b.payment_id = p.id\n"
                    + "inner join ElectricBill eB on b.id = eB.bill_id";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Bill b = new Bill();
                b.setId(rs.getInt("id"));
                Room r = new Room();
                r.setId(rs.getInt("room_id"));
                r.setName(rs.getString("room_name"));
                b.setRoom(r);
                Payment p = new Payment();
                p.setId(rs.getInt("payment_id"));
                p.setTotalPrice(rs.getInt("totalPrice"));
                b.setPayment(p);
                b.setRoomCharge(rs.getInt("room_charge"));
                b.setElectricMoney(rs.getInt("electric_money"));
                b.setWaterMoney(rs.getInt("water_money"));
                b.setNetworkMoney(rs.getInt("network_money"));
                b.setCleanerMoney(rs.getInt("cleaner_money"));
                b.setWaterDrink(rs.getInt("water_drink"));
                b.setStatus(rs.getString("status"));
                b.setShortMoney(rs.getInt("short_money"));
                b.setFromDate(rs.getDate("fromDate"));
                b.setToDate(rs.getDate("toDate"));
                bill.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bill;
    }

    public Bill getBill(int billID) {
        try {
            String sql = "SELECT b.[id]\n"
                    + "                    ,b.[room_id]\n"
                    + "                    ,r.[room_name]\n"
                    + "                    ,b.payment_id\n"
                    + "                    ,b.[room_charge]\n"
                    + "                    ,(eb.[count]*eb.price) as electric_money\n"
                    + "                    ,b.[water_money]\n"
                    + "                    ,b.[network_money]\n"
                    + "                    ,b.[cleaner_money]\n"
                    + "                    ,b.[water_drink]\n"
                    + "                    ,b.[status]\n"
                    + "                    ,b.[short_money]\n"
                    + "                    ,b.[fromDate]\n"
                    + "                    ,b.[toDate]\n"
                    + "                    FROM [Bill] b inner join Room r on b.room_id = r.room_id\n"
                    + "                    inner join ElectricBill eB on b.id = eB.bill_id\n"
                    + "                    Where b.id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, billID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Bill b = new Bill();
                b.setId(rs.getInt("id"));
                Room r = new Room();
                r.setId(rs.getInt("room_id"));
                r.setName(rs.getString("room_name"));
                b.setRoom(r);
                Payment p = new Payment();
                p.setId(rs.getInt("payment_id"));
                b.setPayment(p);
                b.setRoomCharge(rs.getInt("room_charge"));
                b.setElectricMoney(rs.getInt("electric_money"));
                b.setWaterMoney(rs.getInt("water_money"));
                b.setNetworkMoney(rs.getInt("network_money"));
                b.setCleanerMoney(rs.getInt("cleaner_money"));
                b.setWaterDrink(rs.getInt("water_drink"));
                b.setStatus(rs.getString("status"));
                b.setShortMoney(rs.getInt("short_money"));
                b.setFromDate(rs.getDate("fromDate"));
                b.setToDate(rs.getDate("toDate"));
                return b;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateBill(Bill b) {
        String sql = "UPDATE [dbo].[Bill]\n"
                + "   SET [room_charge] = ?\n"
                + "      ,[electric_money] = ?\n"
                + "      ,[water_money] = ?\n"
                + "      ,[network_money] = ?\n"
                + "      ,[cleaner_money] = ?\n"
                + "      ,[water_drink] = ?\n"
                + "      ,[status] = ?\n"
                + "      ,[short_money] = ?\n"
                + " WHERE id = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, b.getRoomCharge());
            stm.setInt(2, b.getElectricMoney());
            stm.setInt(3, b.getWaterMoney());
            stm.setInt(4, b.getNetworkMoney());
            stm.setInt(5, b.getCleanerMoney());
            stm.setInt(6, b.getWaterDrink());
            stm.setString(7, b.getStatus());
            stm.setInt(8, b.getShortMoney());
            stm.setInt(9, b.getId());
            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteBill(int id) {
        String sql = "DELETE Bill\n"
                + " WHERE id = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
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

    public void updateElectricMonney(Bill b) {
        String sql = "UPDATE [dbo].[Bill] \n"
                + " SET \n"
                + " [electric_money] = ?\n"
                + " WHERE id = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, b.getElectricMoney());
            stm.setInt(2, b.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
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

    public void updatePayment(Bill b) {
        String sql = "update Payment set totalPrice = (\n"
                + "select sum(b.room_charge + b.electric_money + b.network_money + b.water_money + b.cleaner_money + b.water_drink + b.short_money)\n"
                + "from Bill as b \n"
                + "inner join Payment p on p.id = b.payment_id\n"
                + "where b.id = ?\n"
                + "group by b.id\n"
                + ")\n"
                + "where id = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, b.getId());
            stm.setInt(2, b.getPayment().getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateDate(Bill b) {
        String sql = "UPDATE [Bill]\n"
                + "   SET\n"
                + "      [fromDate] = ?\n"
                + "      ,[toDate] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setDate(1, b.getFromDate());
            stm.setDate(2, b.getToDate());
            stm.setInt(3, b.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Bill getBillByPayment(int paymentID) {
        String sql = "select b.id,b.fromDate,b.toDate,r.room_name,b.room_charge,b.electric_money,b.water_money,b.network_money,b.cleaner_money,b.water_drink,b.short_money,p.totalPrice\n"
                + "                from Bill b inner join Room r on b.room_id = r.room_id\n"
                + "				inner join Payment p on b.payment_id = p.id\n"
                + "				where payment_id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, paymentID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Bill b = new Bill();
                b.setId(rs.getInt("id"));
                b.setFromDate(rs.getDate("fromDate"));
                b.setToDate(rs.getDate("toDate"));
                Room r = new Room();
                r.setName(rs.getString("room_name"));
                b.setRoom(r);
                b.setRoomCharge(rs.getInt("room_charge"));
                b.setElectricMoney(rs.getInt("electric_money"));
                b.setWaterMoney(rs.getInt("water_money"));
                b.setNetworkMoney(rs.getInt("network_money"));
                b.setCleanerMoney(rs.getInt("cleaner_money"));
                b.setWaterDrink(rs.getInt("water_drink"));
                b.setShortMoney(rs.getInt("short_money"));
                Payment p = new Payment();
                p.setTotalPrice(rs.getInt("totalPrice"));
                b.setPayment(p);
                return b;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
