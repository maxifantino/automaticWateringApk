package com.mgfdev.grama.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

public class Patch implements Serializable{

	private static final long serialVersionUID = -7094207383081555850L;
	
	private Integer id;
	private String patchCode;
	private Float humidityThreshold;
	private Float criticalHumidity;
	private Float humidity;
	private String type;
	private long wateringTime;
	private String status;
	private Float temperature;
	private Date lastCheck;

	private Garden garden;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPatchCode() {
		return patchCode;
	}
	public void setPatchCode(String patchCode) {
		this.patchCode = patchCode;
	}
	public Float getHumidityThreshold() {
		return humidityThreshold;
	}
	public void setHumidityThreshold(Float humidityThreshold) {
		this.humidityThreshold = humidityThreshold;
	}
	public float getCriticalHumidity() {
		return criticalHumidity;
	}
	public void setCriticalHumidity(Float criticalHumidity) {
		this.criticalHumidity = criticalHumidity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getWateringTime() {
		return wateringTime;
	}
	public void setWateringTime(long wateringTime) {
		this.wateringTime = wateringTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Float getHumidity() {
		return humidity;
	}
	public void setHumidity(Float humidity) {
		this.humidity = humidity;
	}

	public void setGarden(Garden garden) {
		this.garden = garden;
	}
	
	public Garden getGarden() {
		return this.garden;
	}

	public Float getTemperature() {
		return temperature;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public String getTemperatureAsString (){
		return temperature != null ? Float.toString(temperature): "N/A";
	}
	public Date getLastCheck() {
		return lastCheck;
	}

	public void setLastCheck(Date lastCheck) {
		this.lastCheck = lastCheck;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
