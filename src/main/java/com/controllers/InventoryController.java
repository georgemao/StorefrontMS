package com.controllers;

import com.Status;
import com.beans.Car;
import com.beans.CarService;
import com.beans.CarServiceActive;
import com.utils.CarInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by George.Mao on 11/18/2014.
 * MVC controller to handle presentation tasks
 */

@Controller
@Profile("local")
public class InventoryController {

    @Autowired
    Environment env;

    @Autowired
    CarInterface cu;

    @Autowired
    @Qualifier("carService")
    CarService cs;

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
        }

        cars.forEach(e -> System.out.println(e));

        // Testing the Spring managed cache
        Car notCached = cu.findCar("1Yzzzzzzzzzzz");
        Car cached = cu.findCar("1Yzzzzzzzzzzz");

        m.addAttribute("inventory", cars);
        return "inventory";
    }

}
