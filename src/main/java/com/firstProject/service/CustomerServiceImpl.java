package com.firstProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.firstProject.model.Customer;
import com.firstProject.model.CustomerStatus;
import com.firstProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.firstProject.service.ConstVariables.ALLOWED_VIP_CUSTOMERS_AMOUNT;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;



    @Override
    public void createCustomer(Customer customer) throws JsonProcessingException {
        if(customer.getCustomerStatus() == CustomerStatus.VIP){
            if(allowVip()){
                customerRepository.createCustomer(customer);
            } else {
                System.out.println("Could not create new VIP customer, out of limit");
            }
        } else {
            customerRepository.createCustomer(customer);
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        if(customer.getCustomerStatus() == CustomerStatus.VIP){
            if(allowVip()){
                customerRepository.updateCustomer(customer);
            } else {
                System.out.println("Could not update new VIP customer, out of limit");
            }
        } else {
            customerRepository.updateCustomer(customer);
        }
    }

    @Override
    public void deleteCustomerById(Long id) {
        deleteCustomerById(id);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomersByFirstName(String firstName) {
        return customerRepository.getAllCustomersByFirstName(firstName);
    }

    @Override
    public List<Long> getAllCustomerIdsByFirstName(String firstName) {
        return customerRepository.getAllCustomerIdsByFirstName(firstName);
    }

    private boolean allowVip(){
        List<Customer> vipCustomers = customerRepository.getAllCustomersByStatus(CustomerStatus.VIP);
        return (vipCustomers.size() < ALLOWED_VIP_CUSTOMERS_AMOUNT);
    }
}
