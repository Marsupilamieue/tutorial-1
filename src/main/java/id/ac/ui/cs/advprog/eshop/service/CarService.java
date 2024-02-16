package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import java.util.List;


public interface CarService {
    public Car create(Car car);
    public void deleteCarById(String id);
    public void update(String id, Car editedCar);
    Car findById(String productId);
    public List<Car> findAll();
}
