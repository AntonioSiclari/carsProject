package com.comdata.Car.Component;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.comdata.Car.DTO.CarDTO;
import com.comdata.Car.Model.Car;

@Component
public class CarComponent {

	private ModelMapper modelMapper;

	public CarComponent(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	// car--to-->carDTO
	public CarDTO modelToDTO(Car car) {
		CarDTO carDTO = this.modelMapper.map(car, CarDTO.class);
		return carDTO;
	}

	// carDTO--to-->car
	public Car DTOtoModel(CarDTO carDTO) {
		Car car = this.modelMapper.map(carDTO, Car.class);
		return car;
	}
}
