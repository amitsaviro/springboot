package com.firstProject.repository;

import com.firstProject.model.Customer;
import com.firstProject.model.CustomerStatus;

import java.util.List;

public interface CustomerRepository {
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomerById(Long id);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomersByFirstName(String firstName);
    List<Long> getAllCustomerIdsByFirstName(String firstName);
    List<Customer> getAllCustomersByStatus(CustomerStatus customerStatus);
}
