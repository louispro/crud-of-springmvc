package com.louis.crud.dao;

import com.louis.crud.bean.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 查询所有部门
     * @return
     */
    public List<Department> getAllDepartments(){
        String sql = "select * from department";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Department.class));
    }

    /**
     * 通过部门查询id
     * @param departmentId
     * @return
     */
    public Department getDepartmentById(Integer departmentId){
        String sql = "select * from department where departmentId=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Department.class),departmentId);
    }

}
