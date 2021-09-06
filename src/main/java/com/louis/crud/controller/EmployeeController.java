package com.louis.crud.controller;

import com.louis.crud.bean.Department;
import com.louis.crud.bean.Employee;
import com.louis.crud.dao.DepartmentDao;
import com.louis.crud.dao.EmployeeDao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @ModelAttribute
    public void myModelAttribute(@RequestParam(value = "id",required = false)Integer id,Model model){
        if(id != null){
            Employee employee = employeeDao.getEmployeeById(id);
            model.addAttribute("employee",employee);
        }
    }

    @RequestMapping("/employees")
    public String getEmployees(Model model){
        List<Employee> employeeList = employeeDao.getAllEmployees();
        model.addAttribute("employees",employeeList);
        return "index";
    }

    /**
     * 前往员工修添加页面
     * @param model
     * @return
     */
    @RequestMapping("/toAddPage")
    public String toAddPage(Model model){
        List<Department> departmentList = departmentDao.getAllDepartments();
        model.addAttribute("departments",departmentList);
        model.addAttribute("employee",new Employee());
        return "addEmployee";
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public String addEmployee(@Valid Employee employee, BindingResult result,Model model){
        //获取校验结果
        boolean hasErrors = result.hasErrors();
        Map<String,Object> errorInfos = new HashMap<>();
        if(hasErrors == true){
            //校验失败
            System.out.println("数据不合法");
            for (FieldError fieldError : result.getFieldErrors()) {
                String errorField = fieldError.getField();  //获取错误字段
                String errorInfo = fieldError.getDefaultMessage(); //获取错误信息
                errorInfos.put(errorField,errorInfo);
            }
            model.addAttribute("errorInfos",errorInfos);
            return "addEmployee";
        }else {
            System.out.println("数据合法");
            employeeDao.saveEmployee(employee);
            return "redirect:/employees";
        }
    }

    /**
     * 前往员工修改页面
     * @return
     */
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String toEditPages(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("employee",employee);
        List<Department> departmentList = departmentDao.getAllDepartments();
        model.addAttribute("departments",departmentList);
        return "editEmployee";
    }

    /**
     * 修改员工信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/employee/{id}",method=RequestMethod.PUT)
    public String updateEmployee(@PathVariable("id") Integer id, @ModelAttribute(value = "employee")Employee employee){
        employeeDao.updateEmployee(employee);
        return "redirect:/employees";
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id")Integer id){
        employeeDao.deleteEmployeeById(id);
        return "redirect:/employees";
    }
}
