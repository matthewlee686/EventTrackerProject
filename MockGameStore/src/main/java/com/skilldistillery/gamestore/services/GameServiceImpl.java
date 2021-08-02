package com.skilldistillery.gamestore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.gamestore.entities.Game;
import com.skilldistillery.gamestore.repositories.GameRepository;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameRepository gameRepo; 

	@Override
	public List<Game> allGames() {
		return gameRepo.findAll();
	}

	@Override
	public Game findGameById(int id) {
		Optional<Game> gameOp = gameRepo.findById(id);
		if(gameOp.isPresent()) {
			return gameOp.get();
		}
		return null; 
	}
	
	@Override
	public Game create(Game game) {
		gameRepo.saveAndFlush(game); 
		return game; 
	}
	
	//update
	@Override
	public Game update(Game game) {
		gameRepo.saveAndFlush(game); 
		return game; 
	} 
  
	
	@Override
	public boolean delete(int id) {
		gameRepo.deleteById(id);
		return !gameRepo.existsById(id);
	}

}
