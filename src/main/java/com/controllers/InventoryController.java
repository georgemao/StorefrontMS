package com.controllers;

import com.Status;
import com.beans.Car;
import com.utils.CarInterface;
import com.utils.CarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by George.Mao on 11/18/2014.
 * MVC controller to handle presentation tasks
 */

@Controller
public class InventoryController {

    @Autowired
    Environment env;

    @Autowired
    CarInterface cu;

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

        // Testing the Spring managed cache
        Car notCached = cu.findCar("1Yzzzzzzzzzzz");
        Car cached = cu.findCar("1Yzzzzzzzzzzz");

        m.addAttribute("inventory", cars);
        return "inventory";
    }

}
