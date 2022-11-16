package com.comdata.Car.DTO;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;


public class CarDTO {


	private UUID id;

	
	@Length(min = 4)
	private String brand;
	
	@NotBlank
	@Length(max = 7)
	private String plate;

	
	

	public CarDTO( String brand, String plate) {
		super();
		this.brand = brand;
		this.plate = plate;
	}

	public CarDTO() {
		super();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	
}
