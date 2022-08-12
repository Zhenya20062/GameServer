package com.euzhene.gameserver.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lobby")
public class LobbyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lobby")
    private List<UserEntity> players;

    public List<UserEntity> getPlayers() {
        return players;
    }

    public void setPlayers(List<UserEntity> players) {
        this.players = players;
    }

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

    private static final int DEFAULT_COUNT_OF_MAX_PLAYERS_IN_LOBBY = 10;
}
