package com.euzhene.gameserver.entity;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class PlayerEntity {
    // todo it should be PlayerEntity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;
    private String username;

    @ManyToOne
    @JoinColumn(name = "lobby_id", nullable = false)
    private LobbyEntity lobby;

    public LobbyEntity getLobby() {
        return lobby;
    }

    public void setLobby(LobbyEntity lobby) {
        this.lobby = lobby;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }
}
