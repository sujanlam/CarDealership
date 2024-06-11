package com.car.controller;

import com.car.entity.Car;
import com.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAll() {
        List<Car> carsByModel = carService.getAllCars();
        return carsByModel;
    }

    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable Long id) {
        return carService.getACar(id);
    }

    @PostMapping
    public void createCar(@RequestBody Car car) {
        carService.createACar(car);
    }

    @GetMapping("/model/{model}")
    public List<Car> getCarByModel(@PathVariable String model) {
        List<Car> carsByModel = carService.getCarsByModel(model);
        return carsByModel;
    }

    @GetMapping("/price/{priceRange}")
    public List<Car> filterCarByPrice(@RequestParam Double priceMin, @RequestParam Double priceMax) {
        List<Car> carsByModel = carService.filterCarsByPrice(priceMin, priceMax);
        return carsByModel;
    }

    @GetMapping("/pricebelow/{price}")
    public List<Car> carsBelowPrice(@PathVariable double price) {
        List<Car> carsBelowGivenPrice = carService.carsBelow(price);
        return carsBelowGivenPrice;
    }

    @GetMapping("/modelAndPrice")
    public List<Car> getCarsByModelAndPrice(@RequestParam String model, @RequestParam Double price
    ) {
        return carService.getCarsByModelAndPrice(model, price);
    }

    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable Long id){
        carService.deleteCar(id);
    }

    @PutMapping("/{id}")
    public void updateCar(@PathVariable Long id, @RequestBody Car car){
        carService.updateCar(id, car);
    }

}
