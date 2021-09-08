package com.louis.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
@Controller
public class HandlerInterceptorController {

    /**
     * 前往拦截器页面
     * @return
     */
    @RequestMapping("toFilterPage")
    public String toFilterPage(){
        return "filter";
    }

    @RequestMapping("filter")
    public String filter(){
        System.out.println("目标方法执行");
        return "success";
    }
}
