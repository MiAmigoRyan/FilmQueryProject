package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;
import java.util.List;

public class Film {
	private List<Actor> actors;
	
	private int filmId;
	private String title;
	private String desc;
	private short releaseYear;
	private int langId;
	private int rentDur;
	private double rate;
	private int length;
	private double repCost;
	private String rating;
	private String features;
	
	
	public Film(int filmId, String title, String desc, short releaseYear, 
			int langId, int rentDur, double rate,
			int length, double repCost, String rating, String features) {		
		this.filmId = filmId;
		this.title = title;
		this.desc = desc;
		this.releaseYear = releaseYear;
		this.langId = langId;
		this.rentDur = rentDur;
		this.rate = rate;
		this.length = length;
		this.repCost = repCost;
		this.rating	= rating;
		this.features = features;
		
	}
	
	

	public Film(String title2, String desc2) {
		this.title = title2;
		this.desc = desc2;
	}


	public Film(int filmId2,String title2, String desc2, int lang, short releaseYear, String rating2) {
		this.filmId = filmId2;
		this.title = title2;
		this.desc = desc2;
		this.langId = lang;
		this.releaseYear = releaseYear;
		this.rating= rating2;
	}



	public List<Actor> getActors() {
		List<Actor> copy = new ArrayList<>(actors);
		return copy;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}






	@Override
	public String toString() {
		return "filmId=" + filmId + "/n title=" + title + "/n desc=" + desc + "\n releaseYear=" + releaseYear
				+ "\n langId=" + langId + "\n rentDur=" + rentDur + "\n rate=" + rate + "\n length=" + length + "\n repCost="
				+ repCost + "\n rating=" + rating + "\n features=" + features;
	}
	
	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public short getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(short releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLangId() {
		return langId;
	}

	public void setLangId(int langId) {
		this.langId = langId;
	}

	public int getRentDur() {
		return rentDur;
	}

	public void setRentDur(int rentDur) {
		this.rentDur = rentDur;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getRepCost() {
		return repCost;
	}

	public void setRepCost(double repCost) {
		this.repCost = repCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}


}
