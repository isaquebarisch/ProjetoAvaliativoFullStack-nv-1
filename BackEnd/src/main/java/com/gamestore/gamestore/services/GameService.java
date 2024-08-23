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

    public List<Game> searchGames(String category, String name, Double minPrice, Double maxPrice,
                                  String platform, String developer, String genre, Double rating,
                                  Integer releaseAfter, Integer releaseBefore, Integer startYear, Integer endYear,
                                  String sortBy, String sortDir, int page, int size) {

        Pageable pageable = PageRequest.of(page, size, "desc".equalsIgnoreCase(sortDir) ?
                org.springframework.data.domain.Sort.by(sortBy).descending() :
                org.springframework.data.domain.Sort.by(sortBy).ascending());

        Specification<Game> spec = Specification.where(GameSpecification.hasCategory(category))
                .and(GameSpecification.nameContains(name))
                .and(GameSpecification.hasPriceRange(minPrice, maxPrice))
                .and(GameSpecification.hasPlatform(platform))
                .and(GameSpecification.hasDeveloper(developer))
                .and(GameSpecification.hasGenre(genre))
                .and(GameSpecification.hasRating(rating))
                .and(GameSpecification.releasedAfter(releaseAfter))
                .and(GameSpecification.releasedBefore(releaseBefore))
                .and(GameSpecification.releasedBetween(startYear, endYear));

        Page<Game> pageResult = gameRepository.findAll(spec, pageable);

        return pageResult.getContent();
    }

}
