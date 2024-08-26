package com.gamestore.gamestore.controllers;

import com.gamestore.gamestore.dtos.GameRecordDto;
import com.gamestore.gamestore.models.Game;
import com.gamestore.gamestore.services.GameService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> searchGames(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String platform,
            @RequestParam(required = false) String developer,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Double rating,
            @RequestParam(required = false) Integer startYear,
            @RequestParam(required = false) Integer endYear,
            @RequestParam(required = false) Integer ageRating,
            @RequestParam(required = false) String publisher,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        if (!"asc".equalsIgnoreCase(sortDir) && !"desc".equalsIgnoreCase(sortDir)) {
            throw new IllegalArgumentException("Invalid sort direction: " + sortDir);
        }

        Sort sort = Sort.by(
                "desc".equalsIgnoreCase(sortDir) ? Sort.Direction.DESC : Sort.Direction.ASC,
                sortBy
        );

        Pageable pageable = PageRequest.of(page, size, sort);

        List<Game> games = gameService.searchGames(
                name, minPrice, maxPrice, developer, rating,
                startYear, endYear, ageRating, publisher, sortBy, sortDir, page, size
        );

        if (category != null && platform != null) {
            return ResponseEntity.status(HttpStatus.OK).body(games.stream().filter(e -> e.getCategory().contains(category) && e.getPlatform().contains(platform)).collect(Collectors.toList()));
        } else if (category != null) {
            return ResponseEntity.status(HttpStatus.OK).body(games.stream().filter(e -> e.getCategory().contains(category)).collect(Collectors.toList()));
        } else if (platform != null) {
            return ResponseEntity.status(HttpStatus.OK).body(games.stream().filter(e -> e.getPlatform().contains(platform)).collect(Collectors.toList()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(games);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id) {
        Game game = gameService.getById(id);
        return game == null ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found") :
                ResponseEntity.status(HttpStatus.OK).body(game);
    }

    @PostMapping
    public ResponseEntity<Game> addGame(@RequestBody @Valid GameRecordDto gameDto) {
        Game gameModel = new Game();
        BeanUtils.copyProperties(gameDto, gameModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(gameService.addGame(gameModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGame(@PathVariable(value = "id") Long id) {
        Game game = gameService.getById(id);
        if(game == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found");
        } else {
            gameService.deleteGame(id);
            return ResponseEntity.status(HttpStatus.OK).body("Game successfully deleted");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateGame(@PathVariable(value = "id") Long id, @RequestBody @Valid GameRecordDto gameRecordDto) {
        Game game = gameService.getById(id);
        if(game == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found");
        } else {
            BeanUtils.copyProperties(gameRecordDto, game);
            return ResponseEntity.status(HttpStatus.OK).body(gameService.updateGame(game));
        }
    }

    @PostMapping("/populate-bank")
    public void populateBank(@RequestBody List<Game> game) {
        game.forEach(e -> gameService.addGame(e));
    }
}
