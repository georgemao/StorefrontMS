package com.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by tiblot on 2/15/2015.
 */

//@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Order")  // 404
public class CommandNotFoundException extends RuntimeException  {


    public CommandNotFoundException(String message) {
        super(message);
    }
}
