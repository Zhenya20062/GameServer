package com.euzhene.gameserver.exception;

public class LobbyAlreadyExistsException extends Exception {
    public LobbyAlreadyExistsException() {
        super("Lobby already exists");
    }
}
