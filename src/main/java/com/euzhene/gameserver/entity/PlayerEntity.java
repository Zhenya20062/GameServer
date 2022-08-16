package com.euzhene.gameserver.entity;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class PlayerEntity {
    public PlayerEntity() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @ManyToOne
    @JoinColumn(name = "lobby_name", nullable = false, referencedColumnName = "name")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
