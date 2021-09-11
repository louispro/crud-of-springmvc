package com.louis.crud.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @赖小燚
 * @www.louis_lai.com
 */

/**
 * 本类专门用于处理异常
 */
//@ControllerAdvice
public class CenterExceptionController {
    /**
     * 此异常处理为全局异常，会处理所有方法的数学异常
     * @param e
     * @return
     */
    @ExceptionHandler(value=ArithmeticException.class)
    public ModelAndView handleError(Exception e){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("ex",e);
        return modelAndView;
    }
}
