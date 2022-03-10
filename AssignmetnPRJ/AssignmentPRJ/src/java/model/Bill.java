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
public class Bill {
    private int id;
    private Room room = new Room();
    private Payment payment = new Payment();
    private int roomCharge;
    private ElectricBill electric = new ElectricBill();
    private int waterMoney,networkMoney,cleanerMoney,waterDrink;
    private String status;
    private int shortMoney;
    private Date fromDate,toDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public int getRoomCharge() {
        return roomCharge;
    }

    public void setRoomCharge(int roomCharge) {
        this.roomCharge = roomCharge;
    }

    public ElectricBill getElectric() {
        return electric;
    }

    public void setElectric(ElectricBill electric) {
        this.electric = electric;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getShortMoney() {
        return shortMoney;
    }

    public void setShortMoney(int shortMoney) {
        this.shortMoney = shortMoney;
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
