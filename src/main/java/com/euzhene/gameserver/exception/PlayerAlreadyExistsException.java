package com.euzhene.gameserver.exception;

public class PlayerAlreadyExistsException extends Exception {
    public PlayerAlreadyExistsException() {
        super("Player has been already added");
    }
}
