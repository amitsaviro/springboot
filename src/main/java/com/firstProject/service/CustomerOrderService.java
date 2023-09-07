package com.firstProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.CustomerOrder;
import com.firstProject.model.CustomerOrderRequest;
import com.firstProject.model.CustomerOrderResponse;

public interface CustomerOrderService {
    CustomerOrderResponse createCustomerOrder(CustomerOrderRequest customerOrderRequest) throws JsonProcessingException;
    CustomerOrderResponse updateCustomerOrderById(CustomerOrderRequest customerOrderRequest);
    void deleteCustomerOrderById(Long id);
    CustomerOrder getCustomerOrderById(Long id);
}
