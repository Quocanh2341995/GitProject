package com.example.demo.dao;

import com.example.demo.model.Department;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO extends ConnectionDB {
    protected String SELECT_ALL_DEPARTMENT_SQL = "SECLECT * FROM db_manager_employee.departments";

    private static final String SELECT_DEPARTMENT_BY_ID = "select id,name from departments where id =?";


    public List<Department> getAll() {
        List <Department> departmentList = new ArrayList<>();
        try {
            PreparedStatement statement = getConnection().prepareStatement(SELECT_ALL_DEPARTMENT_SQL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                departmentList.add(new Department(
                        rs.getInt("id"),
                        rs.getString("name")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return departmentList;
    }

    public Department getById(Long idDepartment) {
        List <Department> departmentList = new ArrayList<>();
        try {
            PreparedStatement statement = getConnection().prepareStatement(SELECT_DEPARTMENT_BY_ID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                departmentList.add(new Department(
                        rs.getLong("id"),
                        rs.getString("name")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new Department();
    }
}


