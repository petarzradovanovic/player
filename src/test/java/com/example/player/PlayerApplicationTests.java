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

//    private EntityManager em;

	@Test
	public void registerPlayer_shouldRegisterPlayer() throws Exception{

		try {
			Player player = new Player();
			player.setId(1L);
			player.setName("player1");

			Long b = playerService.registerPlayer(player);
			assertEquals(1L,b);
		} catch (NullPointerException e) {
			//e.printStackTrace();
			System.out.println("AA");
		}

	}
}
