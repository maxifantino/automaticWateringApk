package com.mgfdev.grama.dto;

import android.icu.text.MessageFormat;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

public class Garden implements Serializable{

	private static final long serialVersionUID = 3790456144218880847L;
	private User user;
	private Integer id;
	private String name;
	private Location location;
	private List<Patch> patches;
	private String workingDays;
	private String workingTimeWindow;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public List<Patch> getPatches() {
		return patches;
	}
	public void setPatches(List<Patch> patches) {
		this.patches = patches;
	}
	public String getWorkingDays() {
		return workingDays;
	}
	public void setWorkingDays(String workingDays) {
		this.workingDays = workingDays;
	}
	public String getWorkingTimeWindow() {
		return workingTimeWindow;
	}
	public void setWorkingTimeWindow(String workingTimeWindow) {
		this.workingTimeWindow = workingTimeWindow;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Float getTemperature (){
		float temperature = 0.0f;
		for (Patch patch: patches){
			temperature+= patch.getTemperature();
		}
		return patches.size() > 0 ?  Float.parseFloat(new java.text.DecimalFormat("0.00").format( temperature / patches.size()))
				: null;
	}

	public String getTemperatureAsString (){
		Float temperature = getTemperature();
		return temperature != null ? Float.toString(temperature): "N/A";
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getReadableLocation(){
		Location location = this.getLocation();
		return java.text.MessageFormat.format("{0},{1}",location.getCity(), location.getCountry());
	}
}
