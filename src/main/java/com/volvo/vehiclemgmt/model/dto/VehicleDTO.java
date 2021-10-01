package com.volvo.vehiclemgmt.model.dto;

import lombok.Data;

@Data
public class VehicleDTO {
	private String chassis;
	private int series;
	private String type;
	private int passenger;
	private String color;
}
