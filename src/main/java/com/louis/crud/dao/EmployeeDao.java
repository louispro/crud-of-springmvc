package com.louis.crud.dao;

import com.louis.crud.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 添加员工
     * @param employee
     */
    public void saveEmployee(Employee employee){
        String sql = "insert into employee value (?,?,?,?,?,?)";
        jdbcTemplate.update(sql,employee.getEmployeeId(),employee.getName(),employee.getEmail(),employee.getGender(),employee.getDepartmentId(),employee.getDepartmentName());
    }

    /**
     * 更新员工信息
     * @param employee
     */
    public void updateEmployee(Employee employee){
        String sql = "update employee set `name`=?,email=?,gender=?,departmentId=?,departmentName=? where employeeId = ?";
        jdbcTemplate.update(sql,employee.getName(),employee.getEmail(),employee.getGender(),employee.getDepartmentId(),employee.getDepartmentName(),employee.getEmployeeId());
    }

    /**
     * 根据id删除员工
     * @param employeeId
     */
    public void deleteEmployeeById(Integer employeeId){
        String sql = "delete from employee where employeeId=?";
        jdbcTemplate.update(sql,employeeId);
    }

    /**
     * 更具id查询员工
     * @param employeeId
     * @return
     */
    public Employee getEmployeeById(Integer employeeId){
        String sql = "select * from employee where employeeId=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Employee.class),employeeId);
    }

    /**
     * 查询所有员工信息
     * @return
     */
    public List<Employee> getAllEmployees(){
        String sql = "select * from employee";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Employee.class));
    }

}
