/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.layered.service.custom;

import edu.ijse.layered.dto.ItemDto;
import edu.ijse.layered.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author kashm
 */
public interface ItemService extends SuperService{
    
    String save(ItemDto itemDto) throws Exception;
    String update(ItemDto itemDto) throws Exception;
    String delete(String itemCode) throws Exception;
    ItemDto get(String itemCode) throws Exception;
    ArrayList<ItemDto> getAll() throws Exception;
    
}
