package com.example.game_db_api.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.game_db_api.model.Game;
import com.example.game_db_api.service.GameService;

@CrossOrigin
@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping

    public ResponseEntity<Game> gameCreate(@RequestBody Game gameToCreate) {
        var gameCreated = gameService.gameCreate(gameToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(gameCreated.getId()).toUri();
        return ResponseEntity.created(location).body(gameCreated);
    }
    // @PostMapping
    // public ResponseEntity<Game> gameCreate(@RequestBody Game gameToCreate) {
    // var gameCreated = gameService.gameCreate(gameToCreate);
    // return ResponseEntity.ok(gameCreated);
    // }

    // extrair valores de variáveis presentes na URL
    @GetMapping("/{id}")
    public ResponseEntity<Game> findById(@PathVariable Integer id) {
        var game = gameService.findById(id);
        return ResponseEntity.ok(game);
    }

    // Editar Status Game
    @PatchMapping("/{id}/status")
    public ResponseEntity<Game> updateGameStatus(@PathVariable Integer id, @RequestBody String status) {
        var updatedGame = gameService.updateGameStatus(id, status);
        return ResponseEntity.ok(updatedGame);
    }

}
