package com.euzhene.gameserver.controller;

import com.euzhene.gameserver.entity.PlayerEntity;
import com.euzhene.gameserver.exception.LobbyNotFoundException;
import com.euzhene.gameserver.exception.PlayerAlreadyExistsException;
import com.euzhene.gameserver.exception.PlayerNotFoundException;
import com.euzhene.gameserver.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    ResponseEntity getPlayerInfo(@RequestParam String name) {
        try {
            return ResponseEntity.ok(playerService.getPlayer(name));
        } catch (PlayerNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @PostMapping
    ResponseEntity connectPlayer(@RequestBody PlayerEntity playerEntity,
                                 @RequestParam String lobbyName) {
        try {
            playerService.addPlayer(playerEntity, lobbyName);
            return ResponseEntity.ok("Player added");
        } catch (PlayerAlreadyExistsException | LobbyNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @DeleteMapping
    ResponseEntity disconnectPlayer(@RequestParam String playerName) {
        try {
            playerService.deletePlayer(playerName);
            return ResponseEntity.ok("Player " + playerName + " disconnected");
        } catch (PlayerNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }
}
