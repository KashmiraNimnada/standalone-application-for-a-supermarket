/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.dao.custom.impl;

import java.sql.ResultSet;
import edu.ijse.layered.dao.CrudUtil;
import edu.ijse.layered.dao.custom.ItemDao;
import edu.ijse.layered.entity.ItemEntity;
import java.util.ArrayList;

/**
 *
 * @author kashm
 */
public class ItemDaoImpl implements ItemDao{

    @Override
    public boolean create(ItemEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO item VALUES(?,?,?,?,?)", t.getItemCode(),t.getDescription(),t.getPackSize(),t.getUnitPrice(),t.getQoh());
    }

    @Override
    public boolean update(ItemEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE item SET Description=?,PackSize=?,UnitPrice=?,QtyOnHand=? WHERE ItemCode=?",t.getDescription(),t.getPackSize(),t.getUnitPrice(),t.getQoh(),t.getItemCode());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM item WHERE ItemCode=?",id);
    }

    @Override
    public ItemEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT*FROM item WHERE ItemCode=?",id);
        if(rst.next()){
            ItemEntity itemEntity = new ItemEntity(rst.getString("ItemCode"),rst.getString("Description"),rst.getString("PackSize"),rst.getDouble("UnitPrice"),rst.getInt("QtyOnHand"));
            return itemEntity;
        }
        return null;
    }   

    @Override
    public ArrayList<ItemEntity> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT*FROM item");
        ArrayList<ItemEntity> entityList = new ArrayList<>();
        while(rst.next()){
            ItemEntity itemEntity = new ItemEntity(rst.getString("ItemCode"),rst.getString("Description"),rst.getString("PackSize"),rst.getDouble("UnitPrice"),rst.getInt("QtyOnHand"));
            entityList.add(itemEntity);
        }
        return entityList;
    }

    
}
