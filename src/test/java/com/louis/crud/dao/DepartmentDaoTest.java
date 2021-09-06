package com.louis.crud.dao;

import com.louis.crud.bean.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springmvc.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DepartmentDaoTest {

    @Autowired
    DepartmentDao departmentDao;
    @Test
    public void getAllDepartments() {
        List<Department> departmentList = departmentDao.getAllDepartments();
        for (Department department : departmentList) {
            System.out.println(department);
        }
    }

    @Test
    public void getDepartmentById() {
        Department department = departmentDao.getDepartmentById(101);
        System.out.println(department);
    }
}