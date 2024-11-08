/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.entity;

/**
 *
 * @author kashm
 */
public class OrderEntity {
    
    private String orderID;
    private String date;
    private String custID;

    public OrderEntity() {
    }

    public OrderEntity(String orderID, String date, String custID) {
        this.orderID = orderID;
        this.date = date;
        this.custID = custID;
    }

    /**
     * @return the orderID
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the custID
     */
    public String getCustID() {
        return custID;
    }

    /**
     * @param custID the custID to set
     */
    public void setCustID(String custID) {
        this.custID = custID;
    }

    @Override
    public String toString() {
        return "OrderEntity{" + "orderID=" + orderID + ", date=" + date + ", custID=" + custID + '}';
    }

    
    
    
}
