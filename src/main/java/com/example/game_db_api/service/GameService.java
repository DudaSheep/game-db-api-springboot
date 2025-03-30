package com.example.game_db_api.service;

import java.util.List;

import com.example.game_db_api.model.Game;
import com.example.game_db_api.model.GameStatus;

public interface GameService {
    Game findById(Integer id);

    Game gameCreate(Game gameToCreate);

    Game updateGameStatus(Integer id, GameStatus status);

    List<Game> findGamesByStatus(GameStatus status);

    List<Game> getAllGames();
}
