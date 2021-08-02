package com.skilldistillery.gamestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.gamestore.entities.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

}
