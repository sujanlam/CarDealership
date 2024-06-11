package com.car.service;

import com.car.entity.Car;
import com.car.repo.CarRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    Logger logger = LogManager.getLogger(CarService.class);
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        logger.info("We are starting the execution of findAll method in service.");
        List<Car> carsList = carRepository.findAll();
        logger.info("List of all cars: "+ carsList);
        return carsList;
    }

    public Optional<Car> getACar(Long id) {
        return carRepository.findById(id);
    }

    public List<Car> getCarsByModel(String model) {
        List<Car> carsList = carRepository.findByModel(model);
        return carsList;
    }

    public List<Car> filterCarsByPrice(Double minPrice, Double maxPrice) {
        List<Car> carsList = carRepository.findByPriceBetween(minPrice, maxPrice);
        return carsList;
    }

    public void createACar(Car car) {
        carRepository.save(car);
    }

    public List<Car> carsBelow(double price) {
        List<Car> carsListBelowGivenPrice = carRepository.findCarsByPriceBefore(price);
        return carsListBelowGivenPrice;
    }

    public List<Car> getCarsByModelAndPrice(String model, Double price) {
        return carRepository.findByModelAndPrice(model, price);
    }

    public void updateCar(Long id, Car updatedCar){
        Optional<Car> optionalCar = carRepository.findById(id);

        if(optionalCar.isPresent()){
            Car existingCar = optionalCar.get();
            existingCar.setYear(updatedCar.getYear());
            existingCar.setModel(updatedCar.getModel());
            existingCar.setPrice(updatedCar.getPrice());
            carRepository.save(existingCar);
        }
        else {
            throw new IllegalArgumentException("Car with "+ id+ " Not found!!!");
        }
    }

    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }

}
