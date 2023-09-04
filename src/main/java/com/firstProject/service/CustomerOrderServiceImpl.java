package com.firstProject.service;

import com.firstProject.model.CustomerOrder;
import com.firstProject.model.CustomerOrderRequest;
import com.firstProject.model.CustomerOrderResponse;
import com.firstProject.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Override
    public CustomerOrderResponse createCustomerOrder(CustomerOrderRequest customerOrderRequest) {
//        customerOrderRepository.createCustomerOrder(customerOrder);
        return null;
    }

    @Override
    public CustomerOrderResponse updateCustomerOrderById(CustomerOrderRequest customerOrderRequest) {
//        customerOrderRepository.updateCustomerOrderById(customerOrder);
        return null;
    }

    @Override
    public void deleteCustomerOrderById(Long id) {
        customerOrderRepository.deleteCustomerOrderById(id);
    }

    @Override
    public CustomerOrder getCustomerOrderById(Long id) {
        return customerOrderRepository.getCustomerOrderById(id);
    }
}
