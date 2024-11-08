/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.layered.service.custom;

import edu.ijse.layered.dto.CustomerDto;
import edu.ijse.layered.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author kashm
 */
public interface CustomerService extends SuperService{
    
    String save(CustomerDto dto) throws Exception;
    String update(CustomerDto dto) throws Exception;
    String delete(String id) throws Exception;
    CustomerDto get(String id) throws Exception;
    ArrayList<CustomerDto> getAll() throws Exception;
}
