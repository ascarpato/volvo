package com.volvo.vehiclemgmt.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.volvo.vehiclemgmt.enums.VehiclePassenger;
import com.volvo.vehiclemgmt.exceptions.BusinessExceptionError;
import com.volvo.vehiclemgmt.model.entities.Vehicle;
import com.volvo.vehiclemgmt.model.entities.VehicleID;
import com.volvo.vehiclemgmt.repositories.VehicleRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VehicleService {
	
	private final VehicleRepository vehicleRepository;
	
	public Vehicle create(Vehicle vehicle) throws BusinessExceptionError {			
		if (!isInVehiclePassengerEnum(vehicle.getType())) {
			throw new BusinessExceptionError("Provided vehicle type is invalid");
		}
		if (vehicle.getChassis().isBlank() || vehicle.getSeries() <= 0 ) {
			throw new BusinessExceptionError("Provided vehicle data is invalid");
		}
		Optional<Vehicle> currentVehicle = vehicleRepository.findOneByChassisAndSeries(vehicle.getChassis(), vehicle.getSeries());
		if (currentVehicle.isPresent()) {
			throw new BusinessExceptionError("Provided vehicle ID already exists");
		}
		return vehicleRepository.save(vehicle);					
	}
	
	public Vehicle getOneByChassis(String chassis, Integer series) throws BusinessExceptionError {	
		if (chassis.isBlank() ) { 
			throw new BusinessExceptionError("Provided chassis id is invalid");
		}
		Optional<Vehicle> currentVehicle = vehicleRepository.findOneByChassisAndSeries(chassis, series);
		if (!currentVehicle.isPresent()) {
			throw new BusinessExceptionError("Provided chassis id was not found");					
		} 
		return currentVehicle.get();	
	}
	
	public List<Vehicle> getAllVehicles() {
		return vehicleRepository.findAll();
	}
	
	public Vehicle update(Vehicle vehicle) throws BusinessExceptionError {
		VehicleID vehicleID = new VehicleID();
		vehicleID.setChassis(vehicle.getChassis());
		vehicleID.setSeries(vehicle.getSeries());
		Optional<Vehicle> currentVehicle = vehicleRepository.findById(vehicleID);
		if (!isInVehiclePassengerEnum(vehicle.getType())) {
			throw new BusinessExceptionError("Vehicle Type is not valid, record not updated");
		}
		if (currentVehicle.isPresent()) {
			Vehicle thisVehicle = currentVehicle.get();
			thisVehicle.setChassis(vehicle.getChassis());
			thisVehicle.setSeries(vehicle.getSeries());
			thisVehicle.setType(vehicle.getType());
			thisVehicle.setColor(vehicle.getColor());			
		} else {
			throw new BusinessExceptionError("Vehicle ID not found, record not updated");
		}				
		return vehicleRepository.save(vehicle);
	}
	
	public String deleteById(String chassis, int series) throws BusinessExceptionError {
		try {
			VehicleID vehicleID = new VehicleID();
			vehicleID.setChassis(chassis);
			vehicleID.setSeries(series);
			vehicleRepository.deleteById(vehicleID);
			return "Vehicle deleted";			
		} catch (Exception e) {
			throw new BusinessExceptionError("Vehicle ID not found, record not deleted");
		}		
	}
	
	private boolean isInVehiclePassengerEnum(String value) {
	    return Arrays.stream(VehiclePassenger.values()).anyMatch(e -> e.name().equals(value));
	  }
}
