package com.louis.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
@Controller
public class ExceptionController {

    @RequestMapping("error")
    public String error(){
        int i = 10/0;
        return "success";
    }

    @RequestMapping("customError")
    public String error(@RequestParam("username") String username){
        if("louis".equals(username) == false){
            System.out.println("用户名不合法");
            throw new UsernameNotFoundException();  //抛出自定义异常
        }
        return "success";
    }

    /**
     * 处理数学异常
     * @return
     */
//    @ExceptionHandler(value = ArithmeticException.class)
//    public ModelAndView handleError(Exception e){
//        ModelAndView modelAndView = new ModelAndView("error");
//        modelAndView.addObject("ex",e);
//        return modelAndView;
//    }

    @RequestMapping("simpleError")
    public String simpleError(){
        String str = null;
        str.equals("louis");
        return "success";
    }



}
