package com.euzhene.gameserver.repository;

import com.euzhene.gameserver.entity.LobbyEntity;
import org.springframework.data.repository.CrudRepository;

public interface LobbyRepository extends CrudRepository<LobbyEntity, Long> {
}
