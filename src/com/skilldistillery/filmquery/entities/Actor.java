package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;
import java.util.List;

public class Actor {
	private int id;
	private String firstName;
	private String lastName;
	private List<Film> films;
	
	public Actor() {
		
	}

	public Actor(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Actor(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	

	public List<Film> getFilms() {
		List<Film> copy = new ArrayList<>(films);
		return copy;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Actor id=" + id + ", firstName=" + firstName + ", lastName=" + lastName ;
	}
	
}
