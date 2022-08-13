package com.euzhene.gameserver.controller;

import com.euzhene.gameserver.entity.LobbyEntity;
import com.euzhene.gameserver.exception.UserNotFoundException;
import com.euzhene.gameserver.service.LobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lobbies")
public class LobbyController {
    @Autowired
    private LobbyService lobbyService;

    @GetMapping
    ResponseEntity getLobbyById(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(lobbyService.getLobby(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @GetMapping
    ResponseEntity getLobbies() {
        try {
            return ResponseEntity.ok(lobbyService.getLobbies());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @PostMapping
    ResponseEntity createLobby(@RequestBody LobbyEntity lobby) {
        try {
            return ResponseEntity.ok(lobbyService.createLobby(lobby));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }
}
