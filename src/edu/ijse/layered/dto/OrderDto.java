/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.dto;

import java.util.ArrayList;

/**
 *
 * @author kashm
 */
public class OrderDto {
    
    private String orderID;
    private String custID;
    private String date;
    private ArrayList<OrderDetailDto> orderDetailDtos;

    public OrderDto() {
    }

    public OrderDto(String orderID, String custID, String date, ArrayList<OrderDetailDto> orderDetailDtos) {
        this.orderID = orderID;
        this.custID = custID;
        this.date = date;
        this.orderDetailDtos = orderDetailDtos;
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
     * @return the orderDetailDtos
     */
    public ArrayList<OrderDetailDto> getOrderDetailDtos() {
        return orderDetailDtos;
    }

    /**
     * @param orderDetailDtos the orderDetailDtos to set
     */
    public void setOrderDetailDtos(ArrayList<OrderDetailDto> orderDetailDtos) {
        this.orderDetailDtos = orderDetailDtos;
    }

    @Override
    public String toString() {
        return "OrderDto{" + "orderID=" + orderID + ", custID=" + custID + ", date=" + date + ", orderDetailDtos=" + orderDetailDtos + '}';
    }
    
    
    
}
