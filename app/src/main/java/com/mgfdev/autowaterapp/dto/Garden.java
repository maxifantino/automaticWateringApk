package com.mgfdev.autowaterapp.dto;

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
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id:" +this.getId() + ", ");
		builder.append("userId:" +this.getUser().getId() + ", ");
		builder.append("name:" +this.getName() + ", ");
		builder.append("location:" +this.getLocation().toString() + ", ");
		builder.append("workingDays:" +this.getWorkingDays() + ", ");
		builder.append("timeWindow:" +this.getWorkingTimeWindow() + ", ");
		builder.append("sprinklers: [");
		if (patches != null) {
			for(Patch sprinkler: patches) {
				builder.append(sprinkler.toString() + ",");
			}		
		}
		builder.append("]");
		return builder.toString();
	}

}
