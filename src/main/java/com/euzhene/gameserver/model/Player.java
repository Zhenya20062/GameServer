package com.euzhene.gameserver.model;

import com.euzhene.gameserver.entity.LobbyEntity;
import com.euzhene.gameserver.entity.PlayerEntity;

public class Player {
    private String username;
    private LobbyEntity lobby;

    public LobbyEntity getLobby() {
        return lobby;
    }

    public void setLobby(LobbyEntity lobby) {
        this.lobby = lobby;
    }

    public static Player toModel(PlayerEntity entity) {
        Player model = new Player();
        model.setUsername(entity.getUsername());
        model.setLobby(entity.getLobby());
        return model;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
