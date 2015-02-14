package com.beans;

import java.util.List;

/**
 * Interface for providing services to our Inventory Restful Web Service
 */
public interface CarService {

    public List<Car> getAllInventory();

    public List<Car> getSoldInventory();

    public List<Car> getActiveInventory();
}
