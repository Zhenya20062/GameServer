package com.euzhene.gameserver.model;

import com.euzhene.gameserver.entity.PlayerEntity;

public class Player {
    private Long id;
    private String username;

    public static Player toModel(PlayerEntity entity) {
        Player model = new Player();
        model.setId(entity.getPlayerId());
        model.setUsername(entity.getUsername());
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
