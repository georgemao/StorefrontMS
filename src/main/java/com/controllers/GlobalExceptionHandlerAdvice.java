package com.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Global Exception handler as a Controller Advice
 * Handles all exceptions not caught at the controller level ie: 404/NotFound
 */
@ControllerAdvice
public class GlobalExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest req, Exception e){

        ModelAndView mav = new ModelAndView();
        mav.addObject("url", req.getRequestURL());
        mav.addObject("error", e);
        mav.setViewName("error");

        return mav;
    }
}
