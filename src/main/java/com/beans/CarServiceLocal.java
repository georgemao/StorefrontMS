package com.beans;

import com.Status;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class implements the Car Service interface. It simulates the Inventory RS WebService
 * Its loaded only when the Conditional LocalCondition is met
 */

@Service
public class CarServiceLocal implements CarService {

    List<Car> cars  = new ArrayList<Car>();

    public CarServiceLocal() {
        Car a= new Car("1Yzzzzzzzzzzz", "Tesla", "MS", "Blue", Status.SOLD);
        Car b= new Car("1Zbbbbbbbbbbb", "Lexus", "RCF", "Black", Status.ACTIVE);

        cars.add(a); cars.add(b);

    }

    @Override
    public List<Car> getAllInventory() {
        return cars;
    }

    @Override
    public List<Car> getSoldInventory() {

        return cars.stream()
                   .filter(e->e.getStatus()==Status.SOLD)
                   .collect(Collectors.toList());
    }

    @Override
    public List<Car> getActiveInventory() {
        return cars.stream()
                   .filter(e->e.getStatus()==Status.ACTIVE)
                   .collect(Collectors.toCollection(ArrayList::new));
    }
}
