package com.beans;

import java.util.List;

/**
 * Created by George Mao on 12/21/2014.
 */
public interface CarService {

    public List<Car> getAllInventory();

    public List<Car> getSoldInventory();

    public List<Car> getActiveInventory();
}
