package com.euzhene.gameserver.exception;

public class LobbyNotFoundException extends Exception{
    public LobbyNotFoundException() {
        super("Lobby not found");
    }
}
