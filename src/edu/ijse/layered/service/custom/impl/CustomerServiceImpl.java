/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.service.custom.impl;

import edu.ijse.layered.dao.DaoFactory;
import edu.ijse.layered.dao.custom.CustomerDao;
import edu.ijse.layered.dto.CustomerDto;
import edu.ijse.layered.entity.CustomerEntity;
import edu.ijse.layered.service.custom.CustomerService;
import java.util.ArrayList;

/**
 *
 * @author kashm
 */
public class CustomerServiceImpl implements CustomerService{
    
    CustomerDao customerDao = (CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CUSTOMER);

    @Override
    public String save(CustomerDto dto) throws Exception {
        return null;
    }

    @Override
    public String update(CustomerDto dto) throws Exception {
        return null;
    }

    @Override
    public String delete(String id) throws Exception {
        return null;
    }

    @Override
    public CustomerDto get(String id) throws Exception {
        CustomerEntity custEntity = customerDao.get(id);
        if(custEntity!=null){
            return entityToDto(custEntity);
        }
        return null;
    }

    @Override
    public ArrayList<CustomerDto> getAll() throws Exception {
        return null;
    }
    
    private CustomerDto entityToDto(CustomerEntity custEntity){
        return new CustomerDto(custEntity.getCustID(),custEntity.getCustTitle(),custEntity.getCustName(),custEntity.getDob(),custEntity.getSalary(),custEntity.getAddress(),custEntity.getCity(),custEntity.getProvince(),custEntity.getPostalCode());
    }
    
}
