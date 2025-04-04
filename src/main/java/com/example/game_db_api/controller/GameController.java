package com.example.game_db_api.controller;

import java.net.URI;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.game_db_api.model.Game;
import com.example.game_db_api.model.GameStatus;
import com.example.game_db_api.service.GameService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @Operation(summary = "Cria um novo jogo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Jogo criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @PostMapping
    public ResponseEntity<Game> gameCreate(@RequestBody Game gameToCreate) {
        var gameCreated = gameService.gameCreate(gameToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(gameCreated.getId()).toUri();
        return ResponseEntity.created(location).body(gameCreated);
    }

    // extrair valores de variáveis presentes na URL
    @Operation(summary = "Retorna um jogo pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Jogo encontrado"),
            @ApiResponse(responseCode = "404", description = "Jogo não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Game> findById(@PathVariable Integer id) {
        var game = gameService.findById(id);
        return ResponseEntity.ok(game);
    }

    // Editar Status Game
    @Operation(summary = "Atualiza o status de um jogo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Status atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Jogo não encontrado")
    })
    @PatchMapping("/{id}/status")
    public ResponseEntity<Game> updateGameStatus(@PathVariable Integer id, @RequestBody GameStatus status) {
        var updatedGame = gameService.updateGameStatus(id, status);
        return ResponseEntity.ok(updatedGame);
    }

    // Retorna jogos pelo status
    @Operation(summary = "Retorna jogos por status")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de jogos retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Status não encontrado")
    })
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Game>> getGamesByStatus(@PathVariable GameStatus status) {
        List<Game> games = gameService.findGamesByStatus(status);
        return ResponseEntity.ok(games);
    }

    // Retorna todos os Jogos
    @Operation(summary = "Retorna todos os jogos cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de jogos retornada com sucesso")
    })
    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = gameService.getAllGames();
        return ResponseEntity.ok(games);
    }

    @Operation(summary = "Deleta um Game pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Game excluido com sucesso"),
            @ApiResponse(responseCode = "500", description = "Game nao encontrado com este Id")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        gameService.deleteGameById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
