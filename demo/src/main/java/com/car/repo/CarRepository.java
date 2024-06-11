package com.car.repo;

import com.car.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByModel(String model);

    List<Car> findByPriceBetween(Double min, Double max);

    List<Car> findCarsByPriceBefore(double price);

    List<Car> findByModelAndPrice(String model, double price);

}
