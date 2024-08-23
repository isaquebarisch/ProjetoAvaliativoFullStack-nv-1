package com.gamestore.gamestore.controllers;


import com.gamestore.gamestore.models.Game;
import com.gamestore.gamestore.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> searchGames(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "platform", required = false) String platform,
            @RequestParam(value = "developer", required = false) String developer
    ) {
        Game game = new Game();
        game.setName(name);
        game.setCategory(category);
        game.setPlatform(platform);
        game.setDeveloper(developer);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Game> example = Example.of(game, matcher);

        List<Game> games = gameService.searchGames(example);

        return ResponseEntity.ok(games);
    }
}
