package com.euzhene.gameserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.euzhene.gameserver.entity.PlayerEntity;

@RestController
public class PlayerController {
    @GetMapping
    ResponseEntity getPlayer() {
        try {
            return ResponseEntity.ok("Ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @PostMapping
    ResponseEntity addPlayer(@RequestBody PlayerEntity player) {
        try {
            return ResponseEntity.ok(player);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }
}
