package com.controllers;

import com.beans.Car;
import com.beans.CarService;
import com.utils.CarInterface;
import com.utils.CommandNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Main Spring MVC controller to handle presentation tasks
 */

@Controller
public class InventoryController {

    @Autowired
    Environment env;

    @Autowired
    CarInterface cu;

    @Autowired
    @Qualifier("carService")
    CarService cs;

    /**
     *
     * @param type
     * @param m
     * @return
     */
    @RequestMapping("/inventory/{type}")
    public String listInventory(@PathVariable String type, Model m){

        System.out.println("Type of listing is: " + type);

        List<Car> cars = null;

        switch(type){
            case "all":
                cars = cs.getAllInventory();
                break;
            case "sold":
                cars = cs.getSoldInventory();
                break;
            case "active":
                cars = cs.getActiveInventory();
                break;
            default:
               throw new CommandNotFoundException(type + " command not found!");
        }

        cars.forEach(e -> System.out.println(e));

        // Testing the Spring managed cache
        Car notCached = cu.findCar("1Yzzzzzzzzzzz");
        Car cached = cu.findCar("1Yzzzzzzzzzzz");

        m.addAttribute("inventory", cars);
        return "inventory";
    }

    /**
     * Error handler for this controller only. Responds to NotFoundExceptions
     * @param req
     * @param e
     * @param m
     * @return a new MAV to present
     * See: http://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
     */
    @ExceptionHandler(CommandNotFoundException.class)
    public ModelAndView handleException(HttpServletRequest req, Exception e){

        ModelAndView mav = new ModelAndView();
        mav.addObject("url", req.getRequestURL());
        mav.addObject("error", e);
        mav.setViewName("error");

        return mav;
    }
}
