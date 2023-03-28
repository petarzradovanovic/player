package com.example.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/")
    public boolean home() {return true;}

    @PostMapping("/register")
    public int registerPlayer(Player player){
        return playerService.registerPlayer(player);
    }

    @GetMapping("/player")
    public Player getPlayerInfo(Player player){
        return playerService.getPlayerInfo(player.getId());
    }

    @DeleteMapping("/player")
    public boolean deletePlayer(Player player){return playerService.deletePlayer(player.getId());
    }
}
