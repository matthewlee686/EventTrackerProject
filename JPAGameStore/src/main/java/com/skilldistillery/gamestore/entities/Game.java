package com.skilldistillery.gamestore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	private String title;
	
	private String description; 
	
	private String platform;
	
	@Column(name="release_year")
	private Integer releaseYear; 
	
	private Integer price;
	
	@Column(name="condition_game")
	private String conditionGame;
	
	//no-arg
	public Game() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getConditionGame() {
		return conditionGame;
	}

	public void setConditionGame(String conditionGame) {
		this.conditionGame = conditionGame;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", title=" + title + ", description=" + description + ", platform=" + platform
				+ ", releaseYear=" + releaseYear + ", price=" + price + ", conditionGame=" + conditionGame + "]";
	}
	
	
}
