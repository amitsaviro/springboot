package com.firstProject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.Customer;
import com.firstProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public void createCustomer(@RequestBody Customer customer) throws JsonProcessingException {
        customerService.createCustomer(customer);
    }

    @PutMapping("/update")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete/{customerId}")
    public void deleteCustomerById(@PathVariable Long customerId){
        customerService.deleteCustomerById(customerId);
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId) throws JsonProcessingException {
        return customerService.getCustomerById(customerId);
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomersByFirstName(@RequestParam String firstName){
        return customerService.getAllCustomersByFirstName(firstName);
    }

    @GetMapping("/allIds")
    public List<Long> getAllCustomerIdsByFirstName(@RequestParam String firstName){
        return customerService.getAllCustomerIdsByFirstName(firstName);
    }

}
