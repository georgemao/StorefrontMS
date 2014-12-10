package com.utils;

import com.Status;
import com.beans.Car;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by George.Mao on 12/3/2014.
 * Business logic functions for cars
 */
public class CarUtil implements CarInterface{

    @Override
    @Cacheable("cars")  // Caches results from this method using the vin as a key
    public Car findCar(String vin){
        System.out.println("Find car invoked!!");

        Car a= new Car(vin, "Tesla", "MS", "Blue", Status.SOLD);
        return a;
    }
}
