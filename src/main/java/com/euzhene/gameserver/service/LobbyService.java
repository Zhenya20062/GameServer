package com.euzhene.gameserver.service;

import com.euzhene.gameserver.entity.LobbyEntity;
import com.euzhene.gameserver.exception.LobbyAlreadyExistsException;
import com.euzhene.gameserver.exception.LobbyNotFoundException;
import com.euzhene.gameserver.model.Lobby;
import com.euzhene.gameserver.repository.LobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LobbyService {
    @Autowired
    private LobbyRepository lobbyRepository;

    public List<Lobby> getLobbies() {
        List<Lobby> lobbyEntities = new ArrayList<>();
        lobbyRepository.findAll().forEach(lobby -> {
            Lobby model = Lobby.toModel(lobby);
            lobbyEntities.add(model);
        });
        return lobbyEntities;
    }

    public Lobby getLobby(String name) throws LobbyNotFoundException {
        LobbyEntity lobby = lobbyRepository.findByName(name);
        if (lobby == null) {
            throw new LobbyNotFoundException();
        }
        return Lobby.toModel(lobby);
    }
    public LobbyEntity createLobby(LobbyEntity lobby) throws LobbyAlreadyExistsException {
        if (lobbyRepository.findByName(lobby.getName()) != null) {
            throw new LobbyAlreadyExistsException();
        }
        return lobbyRepository.save(lobby);
    }
}
