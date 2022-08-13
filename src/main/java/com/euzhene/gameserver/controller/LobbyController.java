package com.euzhene.gameserver.controller;

import com.euzhene.gameserver.entity.LobbyEntity;
import com.euzhene.gameserver.exception.LobbyAlreadyExistsException;
import com.euzhene.gameserver.exception.LobbyNotFoundException;
import com.euzhene.gameserver.service.LobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lobbies")
public class LobbyController {
    @Autowired
    private LobbyService lobbyService;

    @GetMapping(params = {"name"})
    ResponseEntity getLobbyByUsername(@RequestParam String name) {
        try {
            return ResponseEntity.ok(lobbyService.getLobby(name));
        } catch (LobbyNotFoundException e) {
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
        } catch (LobbyAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }
}
