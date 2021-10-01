package com.volvo.vehiclemgmt.model.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleID implements Serializable{

	private static final long serialVersionUID = 1L;
	private int series;
	private String chassis;	
}
