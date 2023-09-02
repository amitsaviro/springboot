package com.firstProject.service;

import com.firstProject.model.Customer;

import java.util.List;

public interface CustomerService {
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomerById(Long id);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomersByFirstName(String firstName);
    List<Long> getAllCustomerIdsByFirstName(String firstName);
}
