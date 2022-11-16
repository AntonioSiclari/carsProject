package com.comdata.Car.Model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "cars")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id")
	
	
	private UUID id;

	
	@Length(min = 4)
	@Column(name = "brand")
	private String brand;


	
	@Length(max = 7)
	@Column(unique = true, name = "plate")
	private String plate;

	
	public Car(String brand, String plate) {
		super();
		this.brand = brand;
		this.plate = plate;
	}

	public Car() {
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

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", plate=" + plate + "]";
	}

}
