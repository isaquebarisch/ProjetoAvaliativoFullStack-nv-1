package com.gamestore.gamestore.services;
import com.gamestore.gamestore.models.Game;
import com.gamestore.gamestore.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> searchGames(Example<Game> example) {
        return gameRepository.findAll(example);
    }

    // Métodos adicionais, como salvar, deletar, etc., podem ser adicionados aqui
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game getGameById(Long id) {
        return gameRepository.findById(id).orElse(null);
    }
}
