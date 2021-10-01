package com.volvo.vehiclemgmt.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.volvo.vehiclemgmt.exceptions.BusinessExceptionError;
import com.volvo.vehiclemgmt.model.entities.Vehicle;
import com.volvo.vehiclemgmt.services.VehicleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {
	
	private final VehicleService vehicleService;
	
	@PostMapping
	public Vehicle create(@RequestBody Vehicle vehicle) throws BusinessExceptionError {	
		return vehicleService.create(vehicle);	
	}
	@PutMapping
	public Vehicle update(@RequestBody Vehicle vehicle) throws BusinessExceptionError {
		return vehicleService.update(vehicle);
	}
	@DeleteMapping
	public String delete(@RequestParam(required=true) String chassi, @RequestParam(required=true) int series) throws BusinessExceptionError {
		return vehicleService.deleteById(chassi, series);
	}
	@GetMapping
	public List<Vehicle> getAll(){
		return vehicleService.getAllVehicles();
	}
	@GetMapping("/chassis")
	public Vehicle getById(@RequestParam(required=true) String chassi, @RequestParam(required=true) int series) throws BusinessExceptionError {
		return vehicleService.getOneByChassis(chassi, series);
	}	
}
