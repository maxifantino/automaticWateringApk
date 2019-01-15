package com.mgfdev.autowaterapp.dto;

import com.mgfdev.autowaterapp.enums.AvailableLanguages;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	
	private static final long serialVersionUID = 4059945026832055572L;
	private Integer id;
	private String username;
	private String password;

	private String email;
	private String name;
	private String surname;
	private AvailableLanguages language;

	private List<Garden> gardens;
 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public AvailableLanguages getLanguage() {
		return language;
	}
	public void setLanguage(AvailableLanguages language) {
		this.language = language;
	}

	public List<Garden> getGardens() {
		return gardens;
	}
	public void setGardens(List<Garden> gardens) {
		this.gardens = gardens;
	}
	
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("id:").append(id).append(",");
		builder.append("username").append(username).append(",");
		builder.append("password:").append(password).append(",");
		builder.append("email:").append(email).append(",");
		builder.append("name").append(name).append(",");
		builder.append("surname:").append(surname).append(",");
		builder.append("language:").append(language).append(",");

		return builder.toString();
	}
	
}
