package com.euzhene.gameserver.controller;

import com.euzhene.gameserver.entity.LobbyEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lobbies")
public class LobbyController {

    @GetMapping
    ResponseEntity getLobbies() {
        try {
            return ResponseEntity.ok("Ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @PostMapping
    ResponseEntity addLobby(@RequestBody LobbyEntity lobby) {
        try {
            return ResponseEntity.ok(lobby);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }
}
