package com.louis.crud.dao;

import com.louis.crud.bean.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springmvc.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeDaoTest {

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void saveEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeId(1008);
        employee.setName("曾国藩");
        employee.setEmail("123@manqing.com");
        employee.setGender(1);
        employee.setDepartmentId(106);
        employee.setDepartmentName("工部");
        employeeDao.saveEmployee(employee);
    }

    @Test
    public void updateEmployee() {
        Employee employee = employeeDao.getEmployeeById(1008);
        employee.setDepartmentId(104);
        employee.setDepartmentName("刑部");
        employeeDao.updateEmployee(employee);
    }

    @Test
    public void deleteEmployeeById() {
        employeeDao.deleteEmployeeById(1008);
    }

    @Test
    public void getEmployeeById() {
        Employee employee = employeeDao.getEmployeeById(1001);
        System.out.println(employee);
    }

    @Test
    public void getAllEmployees() {
        List<Employee> employeeList = employeeDao.getAllEmployees();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}