package com.day.service;

import java.util.List;

import com.day.model.Vehicle;

public interface VehicleService {
	public Vehicle validate(String vehicle_no);
	public Vehicle savevehicle(Vehicle vehicle);
	public void delete(String vehicle_no);
	public List<Vehicle> showall();
	public int update(Vehicle vehicle);
}