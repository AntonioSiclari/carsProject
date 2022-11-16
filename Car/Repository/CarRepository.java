package com.comdata.Car.Repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.comdata.Car.Model.Car;

@Repository
public interface CarRepository extends PagingAndSortingRepository<Car, UUID> {

}
