package com.day.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.day.model.Vehicle;

@Repository
public interface Vehiclerepo extends CrudRepository<Vehicle,String> {

}
