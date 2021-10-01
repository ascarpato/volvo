package com.volvo.vehiclemgmt.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(VehicleID.class)
@Entity
public class Vehicle {
	@Id
	private int series;
	@Id
	private String chassis;	
	private String type;	
	private String color;
}
