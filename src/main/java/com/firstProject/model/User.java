package com.firstProject.model;


public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    private Integer age;

    private String address;

    private String registerDate;
    private Status status;

    public User(){}

    public User(Long id, String firstName, String lastName, String email, Integer age, String address, String registerDate,String status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age=age;
        this.address=address;
        this.registerDate= registerDate;
        this.status= Status.valueOf(status);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getRegisterDate() {
  return registerDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRegisterDate(String registerDate) {
    this.registerDate=registerDate;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
