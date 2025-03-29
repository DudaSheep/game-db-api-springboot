package com.example.game_db_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.game_db_api.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

}
