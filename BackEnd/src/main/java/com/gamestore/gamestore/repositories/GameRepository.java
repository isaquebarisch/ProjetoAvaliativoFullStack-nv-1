package com.gamestore.gamestore.repositories;
import com.gamestore.gamestore.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByCategoryIgnoreCase(String category);

    List<Game> findByPriceBetween(Double minPrice, Double maxPrice);

    List<Game> findByNameContainingIgnoreCase(String name);
}
