package com.example.demo.dao;

import com.example.demo.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeDAO {
    public void insertEmployee(Employee employee) throws SQLException;

    public Employee selectEmployee(long id);

    public List<Employee> selectAllEmployees();

    public boolean deleteEmployee(long id) throws SQLException;

    public boolean updateEmployee(Employee employee) throws SQLException;

}
