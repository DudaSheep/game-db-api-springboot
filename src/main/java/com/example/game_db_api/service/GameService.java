package com.example.game_db_api.service;

import com.example.game_db_api.model.Game;

public interface GameService {
    Game findById(Integer id);

    Game gameCreate(Game gameToCreate);

    Game updateGameStatus(Integer id, String status);

}
