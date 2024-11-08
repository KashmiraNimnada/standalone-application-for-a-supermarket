/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.service.custom.impl;

import edu.ijse.layered.dao.DaoFactory;
import edu.ijse.layered.dao.custom.ItemDao;
import edu.ijse.layered.dao.custom.OrderDao;
import edu.ijse.layered.dao.custom.OrderDetailDao;
import edu.ijse.layered.db.DBConnection;
import edu.ijse.layered.dto.OrderDetailDto;
import edu.ijse.layered.dto.OrderDto;
import edu.ijse.layered.entity.ItemEntity;
import edu.ijse.layered.entity.OrderDetailEntity;
import edu.ijse.layered.entity.OrderEntity;
import edu.ijse.layered.service.custom.OrderService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author kashm
 */
public class OrderServiceImpl implements OrderService{

    OrderDao orderDao = (OrderDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER);
    OrderDetailDao orderDetailDao = (OrderDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER_DETAIL);
    ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);

    
    @Override
    public String placeOrder(OrderDto dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {        
            connection.setAutoCommit(false);
            OrderEntity orderEntity = new OrderEntity(dto.getOrderID(),dto.getDate(),dto.getCustID());
            boolean isOrderPlaced = orderDao.create(orderEntity);
            if(isOrderPlaced){
                boolean isOrderDetailSaved = true;
                ArrayList<OrderDetailDto> orderDetailDtos = dto.getOrderDetailDtos();
                for(OrderDetailDto detailDto : orderDetailDtos){
                    OrderDetailEntity detailEntity = new OrderDetailEntity(dto.getOrderID(),detailDto.getItemID(),detailDto.getQty(),detailDto.getDiscount());
                    System.out.println(detailDto.getOrderID()+detailDto.getItemID()+detailDto.getQty()+detailDto.getDiscount());
                    boolean isDetailSaved = orderDetailDao.create(detailEntity);
                    System.out.println("pasi");
                    if(!(isDetailSaved)){
                        isOrderDetailSaved=false;
                    }
                }
                if(isOrderDetailSaved){
                    boolean allItemsUpdated = true;
                    for(OrderDetailDto details : orderDetailDtos){
                        ItemEntity itemEntity = itemDao.get(details.getItemID());
                        ItemEntity newItemEntity = new ItemEntity(details.getItemID(),itemEntity.getDescription(),itemEntity.getPackSize(),itemEntity.getUnitPrice(),(itemEntity.getQoh()-details.getQty()));
                        boolean itemUpdated = itemDao.update(newItemEntity);
                        if(!(itemUpdated)){
                            allItemsUpdated=false;
                        }
                    }
                    if(allItemsUpdated){
                        connection.commit();
                        return "Success";
                    }else{
                        connection.rollback();
                        return "Item update";
                    }
                }else{
                    connection.rollback();
                    return "Order detail save error";
                }
            }else{
                connection.rollback();
                return "Order save error";
            }
        } catch(Exception e){
            connection.rollback();
            e.printStackTrace();
            throw e;
        } finally{
            connection.setAutoCommit(true);
        }
        
    }
    
}
