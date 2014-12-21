package com.beans;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by George Mao on 12/21/2014.
 */
@Service
public class CarServiceActive implements CarService{

    List<Car> cars  = new ArrayList<Car>();
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Car> getAllInventory() {
        Car[] c = restTemplate.getForObject("http://localhost:8081/inv/getAllCars", Car[].class);

        return Arrays.asList(c);
    }

    @Override
    public List<Car> getSoldInventory() {
        return null;
    }

    @Override
    public List<Car> getActiveInventory() {
        return null;
    }
}

