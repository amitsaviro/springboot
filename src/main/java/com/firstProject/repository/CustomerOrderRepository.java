package com.firstProject.repository;

import com.firstProject.model.CustomerOrder;

public interface CustomerOrderRepository {
    void createCustomerOrder(CustomerOrder customerOrder);
    void updateCustomerOrderById(CustomerOrder customerOrder);
    void deleteCustomerOrderById(Long id);
    CustomerOrder getCustomerOrderById(Long id);
}
