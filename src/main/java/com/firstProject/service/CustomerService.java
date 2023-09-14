package com.firstProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.Customer;

import java.util.List;

public interface CustomerService {
    Long createCustomer(Customer customer) throws JsonProcessingException;
    void updateCustomer(Customer customer);
    void deleteCustomerById(Long id);
    Customer getCustomerById(Long id) throws JsonProcessingException;
    List<Customer> getAllCustomersByFirstName(String firstName);
    List<Long> getAllCustomerIdsByFirstName(String firstName);
}
