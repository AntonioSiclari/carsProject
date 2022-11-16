package com.comdata.Car.Service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.comdata.Car.Component.CarComponent;
import com.comdata.Car.DTO.CarDTO;
import com.comdata.Car.Model.Car;
import com.comdata.Car.Repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

	private CarRepository carRepository;
	private CarComponent carComponent;
	private Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);


	public CarServiceImpl(CarRepository carRepository, CarComponent carComponent) {
		this.carRepository = carRepository;
		this.carComponent = carComponent;
	}

	@Override
	public Car insertCar(Car car) {

		try {
			carRepository.save(car);
			logger.info("insert correctly");
			return car;

		} catch (Exception e) {
			logger.error("problem to insert");
			return null;
		}

	}

	@Override
	public Car deletCar(Car car) {
		try {
			carRepository.delete(car);
			logger.info("delete correctly");
			return car;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Car editCar(Car car) {
		try {
			carRepository.save(car);
			logger.info("edit correctly");
			return car;
		} catch (Exception e) {
			logger.error("problem to edit");
			return null;
		}
	}

	@Override
	public List<Car> getAllCar() {
		try {
			logger.info("show car correctly");
			return (List<Car>) carRepository.findAll();
			
		} catch (Exception e) {
			logger.error("problem to get all car");
			return null;
		}

	}

	public Page<Car> getPage(int page, int items) {
		try {
			return carRepository.findAll(PageRequest.of(page, items));
		} catch (Exception e) {
			return null;
		}
	}
}
