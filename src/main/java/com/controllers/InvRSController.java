package com.controllers;

import com.beans.Car;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * Created by George Mao on 11/29/2014
 * REST Controller to handle Business Logic tasks
 */

@RestController
@RequestMapping("/api")
public class InvRSController {

    @RequestMapping("/sellCar")
    public String sellCar(@RequestParam("vin") String vin){

        System.out.println(vin);

        // Execute Spring RestTemplate and call InventoryMS
        RestTemplate rt = new RestTemplate();
        Optional<Car> result = Optional.ofNullable((Car)rt.getForObject("http://localhost:8081/inv/sellCar?vin="+vin, Car.class));

        if(result.isPresent())
            return result.get().getVin();
        else
            return "0";
    }
}
