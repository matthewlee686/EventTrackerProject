package com.skilldistillery.gamestore.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.gamestore.entities.Game;
import com.skilldistillery.gamestore.services.GameService;

@RequestMapping("api")
@RestController
public class GameController {

	@Autowired
	private GameService svc; 
	
	@GetMapping("games")
	public List<Game> listGames() {
		return svc.allGames();
	}
	
	@GetMapping("games/{id}")
	public Game show(@PathVariable int id,
						HttpServletRequest req, 
						HttpServletResponse res){
		
		Game game = svc.findGameById(id);
		if(game == null) {
			res.setStatus(404);
		}
		
		return game;
	}
	
	@PostMapping("games")
	public Game create(@RequestBody Game game,
							HttpServletRequest req, 
							HttpServletResponse res) {
		
		try {
			System.out.println(game);
			res.setStatus(201);
			game = svc.create(game);
			
			StringBuffer url = req.getRequestURL();
			url.append("/").append(game.getId());
			System.out.println(url);
			
			res.setHeader("Location", url.toString());
			System.out.println(game);
		} catch (Exception e) {
			game = null; 
			res.setStatus(400);
		}
		return game; 
	}
	
	//update
	@PutMapping("games/{id}")
	public Game replace(@RequestBody Game game,
						HttpServletRequest req, 
						HttpServletResponse res){
		try {
			game = svc.update(game);
			if(game == null) {
				res.setStatus(404); 
			}
			
		} catch(Exception e) {
			res.setStatus(400); 
		}
		
		return game; 
	}
	
	
	@DeleteMapping("games/{id}")
	public String deleteGame(@PathVariable Integer id, 
						HttpServletRequest req, 
						HttpServletResponse res) {
		try {
			boolean deleted = svc.delete(id);
			if(deleted) {
				res.setStatus(204);
				return "Deleted";
			} else {
				res.setStatus(404); 
				return "Game not found"; 
			}
		} catch(Exception e) {
			return "Exception";
		}
		
		
	}
	
	
	
}
