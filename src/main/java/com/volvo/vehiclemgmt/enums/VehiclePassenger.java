package com.volvo.vehiclemgmt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum VehiclePassenger {
	
	TRUCKS("TRUCKS", 1),
	BUSES("BUSES", 42),
	CARS("CARS", 4);
	
	private String type;
	private Integer numPassengers;


}
