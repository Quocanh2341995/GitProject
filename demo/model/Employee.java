package com.example.demo.model;

public class Employee {
    private long id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private long salary;
    private Department department;

    public Employee() {
    }

    public Employee(long id, String name, String email, String address, String phone, long salary, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.salary = salary;
        this.department = department;
    }

    public Employee(String name, String email, String address, String phone, long salary, Department department) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.salary = salary;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
