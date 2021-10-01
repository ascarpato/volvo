package com.volvo.vehiclemgmt.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.volvo.vehiclemgmt.model.entities.Vehicle;
import com.volvo.vehiclemgmt.model.entities.VehicleID;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, VehicleID> {

	Optional<Vehicle> findOneByChassisAndSeries(String chassis, Integer series);	
		
}
