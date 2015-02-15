package com.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDateTime;

/**
 * Global Controller Advice that adds timestamps to all Controller RequestMethods
 */
@ControllerAdvice
public class GlobalTimestampAdvice {


    @ModelAttribute
    public void addAttributes(Model model) {

        model.addAttribute("timestamp", LocalDateTime.now());

    }

}
