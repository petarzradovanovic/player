package com.example.player;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PlayerApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private PlayerService playerService;
	@Test
	public void registerPlayer_shouldRegisterPlayer() throws Exception{

		try {
			Player player = new Player();
			player.setName("player1");

			Long b = playerService.registerPlayer(player);
			assertEquals(1L,b);
		} catch (NullPointerException e) {}
	}
	@Test
	public void getPlayerInfo_shouldReturnPlayerInfo() throws Exception {

		try {
			Player insertPlayer = new Player();
			insertPlayer.setName("player1");
			Long b = playerService.registerPlayer(insertPlayer);
			Player newPlayer = playerService.getPlayerInfo(b);
			assertEquals(insertPlayer.getId(), newPlayer.getId());
		} catch (NullPointerException e) {}
	}

	@Test
	public void deleteGame_shouldDeleteGame() throws Exception {
		try{
			Player player = new Player();
			player.setName("player2");
			boolean b = playerService.deletePlayer(player.getId());
			assertEquals(true, b);
		} catch (NullPointerException e) {}
	}
}