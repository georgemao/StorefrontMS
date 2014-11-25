package com.controllers;

import com.Status;
import com.beans.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by George.Mao on 11/18/2014.
 */

@Controller
public class InventoryController {

    @Autowired
    Environment env;

    @RequestMapping("/inventory")
    public String listInventory(Model m){

        Car[] c = null;

        List profile = Arrays.asList(env.getActiveProfiles());
        if(profile.contains("invms")){
            RestTemplate restTemplate = new RestTemplate();
            c = restTemplate.getForObject("http://localhost:8081/inv/getAllCars", Car[].class);
        }
        else{
            c = new Car[2];
            Car a= new Car("1Yzzzzzzzzzzz", "Tesla", "MS", "Blue", Status.SOLD);
            Car b= new Car("1Zbbbbbbbbbbb", "Lexus", "RCF", "Black", Status.ACTIVE);
            c[0]=a;
            c[1]=b;
        }

        List<Car> cars = Arrays.asList(c);
        cars.forEach(e -> System.out.println(e));

        m.addAttribute("inventory", cars);
        return "inventory";
    }
}
