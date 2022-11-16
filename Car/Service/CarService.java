package com.comdata.Car.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.comdata.Car.Model.Car;

public interface CarService {

	// crud operations

	public Car insertCar(Car car);

	public Car deletCar(Car car);

	public Car editCar(Car car);

	public List<Car> getAllCar();

	public Page<Car> getPage(int page, int items);

}
