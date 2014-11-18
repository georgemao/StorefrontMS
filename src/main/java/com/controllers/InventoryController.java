package com.controllers;

import com.beans.Car;
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

    @RequestMapping("/inventory")
    public String listInventory(Model m){

        System.out.println("in");

        RestTemplate restTemplate = new RestTemplate();
        Car[] c = restTemplate.getForObject("http://localhost:8081/inv/getAllCars", Car[].class);

        List<Car> cars = Arrays.asList(c);
        cars.forEach(e -> System.out.println(e));

        m.addAttribute("inventory", cars);
        return "inventory";
    }
}
