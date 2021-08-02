package com.skilldistillery.gamestore.services;

import java.util.List;

import com.skilldistillery.gamestore.entities.Game;

public interface GameService {
	public List<Game> allGames(); 
	public Game findGameById(int id); 
	public Game create(Game game); 
	public Game update(Game game); 
	public boolean delete(int id); 
}
