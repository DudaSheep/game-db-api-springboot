package com.example.game_db_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.game_db_api.model.Game;
import com.example.game_db_api.model.GameStatus;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    // SELECT * FROM TB_GAME WHERE STATUS = 'FINISHED'
    List<Game> findByStatus(GameStatus status);
}
