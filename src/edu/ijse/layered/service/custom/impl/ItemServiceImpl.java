/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.service.custom.impl;

import edu.ijse.layered.dao.DaoFactory;
import edu.ijse.layered.dao.custom.ItemDao;
import edu.ijse.layered.dto.ItemDto;
import edu.ijse.layered.entity.ItemEntity;
import edu.ijse.layered.service.custom.ItemService;
import java.util.ArrayList;

/**
 *
 * @author kashm
 */
public class ItemServiceImpl implements ItemService{
    
    private ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);
    
    @Override
    public String save(ItemDto itemDto) throws Exception{      
        ItemEntity itemEntity = dtoToEntity(itemDto);
        return itemDao.create(itemEntity) ? "Success" : "Fail";                  
    }

    @Override
    public String update(ItemDto itemDto) throws Exception{
        ItemEntity itemEntity = dtoToEntity(itemDto);
        return itemDao.update(itemEntity) ? "Success" : "Fail";
    }

    @Override
    public String delete(String itemCode) throws Exception{
        return itemDao.delete(itemCode) ? "Success" : "Fail";
    }

    @Override
    public ItemDto get(String itemCode) throws Exception{
        ItemEntity itemEntity = itemDao.get(itemCode);
        if(itemEntity!=null){
            return entityToDto(itemEntity);
        }
        return null;
    }

    @Override
    public ArrayList<ItemDto> getAll() throws Exception{
        ArrayList<ItemEntity> entityList = itemDao.getAll();
        if (entityList!=null){
            ArrayList<ItemDto> itemDtoList = new ArrayList<>();
            for(ItemEntity itemEntity : entityList){
                itemDtoList.add(new ItemDto(itemEntity.getItemCode(),itemEntity.getDescription(),itemEntity.getPackSize(),itemEntity.getUnitPrice(),itemEntity.getQoh()));
            }
            return itemDtoList;
        }
        return null;
    }
    
    private ItemEntity dtoToEntity(ItemDto itemDto){
        return new ItemEntity(itemDto.getItemCode(),itemDto.getDescription(),itemDto.getPackSize(),itemDto.getUnitPrice(),itemDto.getQoh());       
    }
    
    private ItemDto entityToDto(ItemEntity itemEntity){
        return new ItemDto(itemEntity.getItemCode(),itemEntity.getDescription(),itemEntity.getPackSize(),itemEntity.getUnitPrice(),itemEntity.getQoh());
    }
    
}
