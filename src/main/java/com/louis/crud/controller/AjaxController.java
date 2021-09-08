package com.louis.crud.controller;

import com.louis.crud.bean.Employee;
import com.louis.crud.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
@Controller
public class AjaxController {

    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping("/toAjaxPage")
    public String toAjaxPage(){
        return "ajax";
    }

    /**
     * @ResponseBody将返回的数据放在响应体中，如果是对象则将对象转为json格式
     * @return
     */
    @ResponseBody
    @RequestMapping("/employeesByAjax")
    public List<Employee> getEmployeesByAjax(){
        List<Employee> employees = employeeDao.getAllEmployees();
        return employees;
    }

    /**
     * HttpEntity<T>同时获取请求头和所有请求体
     * @param body
     * @return
     */
    @RequestMapping("getJson")
    public String getJson(HttpEntity<String> body){
        System.out.println(body);
        return  "success";
    }

    /**
     * 直接将响应头解析为bean
     * @param employee
     * @return
     */
    @RequestMapping("getJson_1")
    public String getJson_1(@RequestBody Employee employee){
        System.out.println(employee);
        return "success";
    }

    /**
     * ResponseEntity<>返回响应头和响应体
     * @return
     */
    @RequestMapping("responseEntity")
    public ResponseEntity<String> responseEntity(){
        String response = "<h1>success<h1>";
        MultiValueMap<String,String> headers = new HttpHeaders();
        headers.add("Set-Cookie","username=haahah");
        return new ResponseEntity<>(response,headers, HttpStatus.OK);
    }

    /**
     * ResponseEntity<Byte[]>文件下载
     * @return
     */
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
        ServletContext context = request.getServletContext();
        //1.获取要下载文件的真实路径
        String realPath = context.getRealPath("/static/jquery-1.9.1.min.js");
        System.out.println("文件完整路径:"+realPath);
        //2.获取下载文件的流
        FileInputStream fileInputStream = new FileInputStream(realPath);
        byte[] tmp = new byte[fileInputStream.available()];
        fileInputStream.read(tmp);
        fileInputStream.close();    //关闭流
        //3.返回流
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Disposition","attachment;filename="+"jquery-1.9.1.min.js");
        return new ResponseEntity<>(tmp,headers,HttpStatus.OK);
    }
}
