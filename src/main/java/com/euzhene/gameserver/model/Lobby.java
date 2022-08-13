package com.euzhene.gameserver.model;

import com.euzhene.gameserver.entity.LobbyEntity;
import com.euzhene.gameserver.entity.UserEntity;

import java.util.List;

public class Lobby {
    private String name;
    private List<UserEntity> players;
    private int maxPlayers;


    public String getName() {
        return name;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserEntity> getPlayers() {
        return players;
    }

    public void setPlayers(List<UserEntity> players) {
        this.players = players;
    }

   public static Lobby toModel(LobbyEntity entity) {
        Lobby lobby = new Lobby();
        lobby.setName(entity.getName());
        lobby.setPlayers(entity.getPlayers());
        lobby.setMaxPlayers(entity.getMaxPlayers());
        return lobby;
    }
}
