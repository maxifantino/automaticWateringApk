package com.mgfdev.autowaterapp.dto;

import java.io.Serializable;

public class Location implements Serializable{
	
	private static final long serialVersionUID = 1926261411609868355L;
	private Integer id;
	private String country;
	private String city;
	private String address;
	private Double longitude;
	private Double latitude;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("id: " + this.getId() + ", ");
		builder.append("country" + this.getCountry() + ", ");
		builder.append("city: " + this.getCity() + ", ");
		builder.append("address: " + this.getAddress() + ", ");
		builder.append("longitude: " + this.getLongitude() + ", ");
		builder.append("latitude" + this.getLatitude() + ", ");
		
		return builder.toString();
		
	}
}
