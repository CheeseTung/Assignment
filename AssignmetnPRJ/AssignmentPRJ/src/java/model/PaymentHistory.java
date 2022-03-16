/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author chitung
 */
public class PaymentHistory {
    private int id;
    private Payment payment = new Payment();
    private Bill bill = new Bill();
    private String roomName;
    private int roomCharge,electricMoney,waterMoney,networkMoney,cleanerMoney,waterDrink,shortMoney,totalPrice;
    private Date fromDate, toDate;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomCharge() {
        return roomCharge;
    }

    public void setRoomCharge(int roomCharge) {
        this.roomCharge = roomCharge;
    }

    public int getElectricMoney() {
        return electricMoney;
    }

    public void setElectricMoney(int electricMoney) {
        this.electricMoney = electricMoney;
    }

    public int getWaterMoney() {
        return waterMoney;
    }

    public void setWaterMoney(int waterMoney) {
        this.waterMoney = waterMoney;
    }

    public int getNetworkMoney() {
        return networkMoney;
    }

    public void setNetworkMoney(int networkMoney) {
        this.networkMoney = networkMoney;
    }

    public int getCleanerMoney() {
        return cleanerMoney;
    }

    public void setCleanerMoney(int cleanerMoney) {
        this.cleanerMoney = cleanerMoney;
    }

    public int getWaterDrink() {
        return waterDrink;
    }

    public void setWaterDrink(int waterDrink) {
        this.waterDrink = waterDrink;
    }

    public int getShortMoney() {
        return shortMoney;
    }

    public void setShortMoney(int shortMoney) {
        this.shortMoney = shortMoney;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
    
}
