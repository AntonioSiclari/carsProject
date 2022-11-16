package com.comdata.Car.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.comdata.Car.Component.CarComponent;
import com.comdata.Car.DTO.CarDTO;
import com.comdata.Car.Model.Car;
import com.comdata.Car.Service.CarService;

@RestController
public class CarController {

	private CarService carService;
	private CarComponent carComponent;

	public CarController(CarService carService, CarComponent carComponent) {
		this.carComponent = carComponent;
		this.carService = carService;
	}

	// insert
	@PostMapping("/car")
	public CarDTO insert(@Valid @RequestBody CarDTO carDTO) {
		Car dtoToModel = carComponent.DTOtoModel(carDTO);
		carService.insertCar(dtoToModel);
		return carDTO;

	}

	@DeleteMapping("/car")
	public CarDTO delete(@Valid @RequestBody CarDTO carDTO) {
		Car dtoToModel = carComponent.DTOtoModel(carDTO);
		carService.deletCar(dtoToModel);
		return carDTO;
	}

	@GetMapping("/car")
	public List<Car> getAll() {
		return carService.getAllCar();
	}

	@PutMapping("/car")
	public CarDTO edit(@Valid @RequestBody CarDTO carDTO) {

		Car dtoToModel = carComponent.DTOtoModel(carDTO);
		carService.editCar(dtoToModel);
		System.out.println(dtoToModel);
		return carDTO;

	}

	@GetMapping("/page/{page}/items/{items}")
	public Page<CarDTO> showAllCar(@PathVariable int page, @PathVariable int element) {
		Page<Car> listCar = carService.getPage(page, element);
		List<Car> cars = listCar.toList();
		List<CarDTO> carsDto = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			CarDTO carDto = carComponent.modelToDTO(cars.get(i));
			carsDto.add(carDto);
		}
		Page<CarDTO> pageCarDto = new PageImpl<>(carsDto, PageRequest.of(page, element), Long.valueOf(carsDto.size()));
		return pageCarDto;
	}

}
