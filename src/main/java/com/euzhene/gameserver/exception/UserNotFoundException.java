package com.euzhene.gameserver.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super("User not found");
    }
}
