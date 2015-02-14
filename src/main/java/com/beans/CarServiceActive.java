package com.beans;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class implements the Car Service interface to provide a client to the Inventory RS WebService
 * Its loaded only when the Conditional ActiveCondition is met
 */
@Service
public class CarServiceActive implements CarService{

    List<Car> cars  = new ArrayList<Car>();
    RestTemplate restTemplate = new RestTemplate();

    /**
     *
     * @return
     */
    @Override
    public List<Car> getAllInventory() {
        Car[] c = restTemplate.getForObject("http://localhost:8081/inv/getAllCars", Car[].class);

        return Arrays.asList(c);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Car> getSoldInventory() {
        return null;
    }

    /*

     */
    @Override
    public List<Car> getActiveInventory() {
        return null;
    }
}

