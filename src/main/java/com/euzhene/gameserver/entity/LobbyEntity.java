package com.euzhene.gameserver.entity;


import javax.persistence.*;

@Entity
@Table(name = "lobby")
public class LobbyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    private int maxPlayers = DEFAULT_COUNT_OF_MAX_PLAYERS_IN_LOBBY;

    public LobbyEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static final int DEFAULT_COUNT_OF_MAX_PLAYERS_IN_LOBBY = 10;
}
