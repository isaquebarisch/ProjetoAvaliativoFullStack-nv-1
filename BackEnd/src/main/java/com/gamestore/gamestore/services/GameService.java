package com.gamestore.gamestore.services;

import com.gamestore.gamestore.models.Game;
import com.gamestore.gamestore.repositories.GameRepository;
import com.gamestore.gamestore.specifications.GameSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> searchGames(String name, Double minPrice, Double maxPrice,
                                  String developer, Double rating,
                                  Integer startYear, Integer endYear, Integer ageRating, String publisher,
                                  String sortBy, String sortDir, Integer page, Integer size) {

        Pageable pageable = PageRequest.of(page, size, "desc".equalsIgnoreCase(sortDir) ?
                org.springframework.data.domain.Sort.by(sortBy).descending() :
                org.springframework.data.domain.Sort.by(sortBy).ascending());

        Specification<Game> spec = Specification
//                .where(GameSpecification.hasCategory(category))
                .where(GameSpecification.nameContains(name))
                .and(GameSpecification.hasPriceRange(minPrice, maxPrice))
//                .and(GameSpecification.hasPlatform(platform))
                .and(GameSpecification.hasDeveloper(developer))
                .and(GameSpecification.hasRating(rating))
                .and(GameSpecification.hasAgeRating(ageRating))
                .and(GameSpecification.hasPublisher(publisher))
                .and(GameSpecification.releasedBetween(startYear, endYear));

        Page<Game> pageResult = gameRepository.findAll(spec, pageable);

        return pageResult.getContent();
    }

    public Game getById(Long id) {
        return gameRepository.findById(id).orElse(null);
    }

    public Game addGame(Game game) {
        return gameRepository.save(game);
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

    public Game updateGame(Game game) {
        return gameRepository.save(game);
    }
}
