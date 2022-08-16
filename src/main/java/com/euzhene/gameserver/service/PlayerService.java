package com.euzhene.gameserver.service;

import com.euzhene.gameserver.entity.LobbyEntity;
import com.euzhene.gameserver.entity.PlayerEntity;
import com.euzhene.gameserver.exception.LobbyNotFoundException;
import com.euzhene.gameserver.exception.PlayerAlreadyExistsException;
import com.euzhene.gameserver.exception.PlayerNotFoundException;
import com.euzhene.gameserver.model.Lobby;
import com.euzhene.gameserver.model.Player;
import com.euzhene.gameserver.repository.LobbyRepository;
import com.euzhene.gameserver.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private LobbyRepository lobbyRepository;
    @Autowired
    private LobbyService lobbyService;

    public Player getPlayer(String name) throws PlayerNotFoundException {
        PlayerEntity playerEntity = playerRepository.findByUsername(name);
        if (playerEntity == null) {
            throw new PlayerNotFoundException();
        }
        return Player.toModel(playerEntity);
    }

    public void addPlayer(PlayerEntity entity, String lobbyName) throws PlayerAlreadyExistsException, LobbyNotFoundException {
        if (playerRepository.findByUsername(entity.getUsername()) != null) {
            throw new PlayerAlreadyExistsException();
        }
        LobbyEntity lobby = lobbyRepository.findByName(lobbyName);
        if (lobby == null) {
            throw new LobbyNotFoundException();
        }

        entity.setLobby(lobby);
        playerRepository.save(entity);
    }

    public void deletePlayer(String playerName) throws PlayerNotFoundException {
        PlayerEntity playerEntity = playerRepository.findByUsername(playerName);
        if (playerEntity == null) {
            throw new PlayerNotFoundException();
        }
        playerRepository.delete(playerEntity);
        lobbyService.deletePlayerFromLobby(playerEntity);
    }

}
