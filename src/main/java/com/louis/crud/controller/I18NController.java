package com.louis.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
@Controller
public class I18NController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("toLoginPage")
    public String toLoginPage(@RequestParam(value = "locale",defaultValue = "zh_CN",required = false) String localeStr, Locale locale, HttpSession session){
        System.out.println("区域信息:"+locale);
        String welcomeinfo = messageSource.getMessage("welcomeinfo",null,locale);
        System.out.println(welcomeinfo);
        System.out.println(localeStr);
        Locale l = null;
        if(localeStr != null && "".equals(localeStr)){
            l = new Locale(localeStr.split("_")[0],localeStr.split("_")[1]);
        }else {
            l = locale;
        }
        session.setAttribute(SessionLocaleResolver.class.getName()+".LOCALE",l);
        return "login";
    }
}
