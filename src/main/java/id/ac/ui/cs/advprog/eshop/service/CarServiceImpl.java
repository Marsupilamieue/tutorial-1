package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    
    @Autowired
    private CarRepository CarRepository;

    @Override
    public Car create(Car car){
        CarRepository.create(car);
        return car;
    }

    @Override
    public List<Car> findAll() {
        Iterator<Car> CarIterator = CarRepository.findAll();
        List<Car> allCar = new ArrayList<>();
        CarIterator.forEachRemaining(allCar::add);
        return allCar;
    }

    @Override
    public Car findById(String CarId){
        Car car = CarRepository.findById(CarId);
        return car;
    }

    @Override
    public void deleteCarById(String CarId){
        CarRepository.delete(CarId);
    }

    @Override
    public void update(String id, Car editedCar){
        CarRepository.update(id, editedCar);
    }

}
