package com.firstProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderRequest {
    @JsonProperty("customer_name")
    private String customerName;
    private Item item;
    private Integer price;

    public OrderRequest(){}

    public OrderRequest(String customerName, Item item, Integer price) {
        this.customerName = customerName;
        this.item = item;
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Item getItem() {
        return item;
    }

    public Integer getPrice() {
        return price;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setItemName(Item item) {
        this.item = item;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
