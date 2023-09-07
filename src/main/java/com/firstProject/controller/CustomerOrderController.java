package com.firstProject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.CustomerOrder;
import com.firstProject.model.CustomerOrderRequest;
import com.firstProject.model.CustomerOrderResponse;
import com.firstProject.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customerOrder")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @PostMapping("/create")
    public CustomerOrderResponse createCustomerOrder(@RequestBody CustomerOrderRequest customerOrderRequest) throws JsonProcessingException {
        return customerOrderService.createCustomerOrder(customerOrderRequest);
    }

    @PutMapping("/update")
    public CustomerOrderResponse updateCustomerOrder(@RequestBody CustomerOrderRequest customerOrderRequest){
        customerOrderService.updateCustomerOrderById(customerOrderRequest);
        return null;
    }

    @DeleteMapping("/delete/{customerOrderId}")
    public void deleteCustomerById(@PathVariable Long customerOrderId){
        customerOrderService.deleteCustomerOrderById(customerOrderId);
    }

    @GetMapping("/{customerOrderId}")
    public CustomerOrder getCustomerOrderById(@PathVariable Long customerOrderId){
        return customerOrderService.getCustomerOrderById(customerOrderId);
    }
}
