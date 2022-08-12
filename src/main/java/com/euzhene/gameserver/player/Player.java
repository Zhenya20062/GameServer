package com.euzhene.gameserver.player;

import org.springframework.web.bind.annotation.PostMapping;

public class Player {
    private Long playerId;
    private String username;

    @PostMapping
    public Long getId() {
        return playerId;
    }
}
