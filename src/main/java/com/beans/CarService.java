package com.beans;

import java.util.List;

/**
 * Interface for providing services to our Inventory Restful Web Service
 */
public interface CarService {

    /**
     * Return all avail. inventory
     * @return
     */
    public List<Car> getAllInventory();

    /**
     * Return only the Cars that are sold
     * @return
     */
    public List<Car> getSoldInventory();

    /**
     * Return all unsold/active Cars
     * @return
     */
    public List<Car> getActiveInventory();
}
