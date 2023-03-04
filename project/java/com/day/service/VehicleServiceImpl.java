package com.day.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day.dao.Vehiclerepo;
import com.day.model.Vehicle;
@Service
public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	Vehiclerepo vrep;
	
	@Override
	public Vehicle validate(String vehicle_no) {
		Optional<Vehicle> opt= vrep.findById(vehicle_no);
		return opt.get();
	}

	@Override
	public Vehicle savevehicle(Vehicle vehicle) {
		return vrep.save(vehicle);
	}

	@Override
	public void delete(String vehicle_no) {
		vrep.deleteById(vehicle_no);
		
	}

	@Override
	public List<Vehicle> showall() {
		return (List<Vehicle>)vrep.findAll();
	}

	@Override
	public int update(Vehicle vehicle) {
		vrep.save(vehicle);
		return 0;
	}

}
