package com.euzhene.gameserver.repository;

import org.springframework.data.repository.CrudRepository;

import com.euzhene.gameserver.entity.PlayerEntity;

public interface PlayerRepo extends CrudRepository<PlayerEntity, Long> {
    PlayerEntity findByUsername(String username);
}
