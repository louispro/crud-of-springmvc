package com.louis.crud.controller;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class MyLocaleResolver implements LocaleResolver {
    /**
     * 解析返回locale
     */
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String localeStr = httpServletRequest.getParameter("locale");
        Locale l = null;
        if(localeStr != null && !"".equals(localeStr)){
            l = new Locale(localeStr.split("_")[0],localeStr.split("_")[1]);
        }else {
            l = httpServletRequest.getLocale();
        }
        return l;
    }

    /**
     * 修改locale
     * @param httpServletRequest
     * @param httpServletResponse
     * @param locale
     */
    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {
        throw new UnsupportedOperationException("Cannot change HTTP accept header - use a different locale");
    }
}
