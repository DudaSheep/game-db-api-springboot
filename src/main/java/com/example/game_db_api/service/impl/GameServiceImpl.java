package com.example.game_db_api.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.game_db_api.model.Game;
import com.example.game_db_api.model.GameStatus;
import com.example.game_db_api.repository.GameRepository;
import com.example.game_db_api.service.GameService;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game findById(Integer id) {
        return gameRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    @Transactional
    public Game gameCreate(Game gameToCreate) {
        return gameRepository.save(gameToCreate);
    }

    @Override
    @Transactional
    public Game updateGameStatus(Integer id, GameStatus status) {
        var game = gameRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Game not found with id: " + id));
        game.setStatus(status);
        return gameRepository.save(game);
    }

    @Override
    public List<Game> findGamesByStatus(GameStatus status) {
        return gameRepository.findByStatus(status);
    }
}
