package com.skilldistillery.gamestore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.gamestore.entities.Game;
import com.skilldistillery.gamestore.repositories.GameRepository;

@SpringBootTest
class MockGameStoreApplicationTests {

	@Autowired
	private GameRepository gameRepo; 
	
	@Test
	@DisplayName("Find Game by Id")
	void test1() {
		Optional<Game> g = gameRepo.findById(1);
		if(g.isPresent()) {
			assertNotNull(g);
			assertEquals(1, g.get().getId());
		} else {
			fail("No Game Found");
		}
			
	}

}
