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
    public Long registerPlayer(@RequestBody Player player){
        return playerService.registerPlayer(player);
    }

    @GetMapping("/player")
    public Player getPlayerInfo(Player player) throws Exception { return playerService.getPlayerInfo(player.getId());
    }

    @DeleteMapping("/player")
    public boolean deletePlayer(Player player) throws Exception {return playerService.deletePlayer(player.getId());
    }
}
