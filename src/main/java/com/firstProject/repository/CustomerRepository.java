package com.firstProject.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.Customer;
import com.firstProject.model.CustomerStatus;

import java.util.List;

public interface CustomerRepository {
    Long createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomerById(Long id);
    Customer getCustomerById(Long id) throws JsonProcessingException;
    List<Customer> getAllCustomersByFirstName(String firstName);
    List<Long> getAllCustomerIdsByFirstName(String firstName);
    List<Customer> getAllCustomersByStatus(CustomerStatus customerStatus);
}
