package com.louis.crud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
@ResponseStatus(reason = "用户名不存在",value = HttpStatus.NOT_ACCEPTABLE)
public class UsernameNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
}
