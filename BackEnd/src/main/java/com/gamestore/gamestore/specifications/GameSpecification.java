package com.gamestore.gamestore.specifications;
import com.gamestore.gamestore.models.Game;
import org.springframework.data.jpa.domain.Specification;

public class GameSpecification {

    public static Specification<Game> hasCategory(String category) {
        return (root, query, criteriaBuilder) ->
                category == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("category")), "%" + category.toLowerCase() + "%");
    }

    public static Specification<Game> nameContains(String name) {
        return (root, query, criteriaBuilder) ->
                name == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Game> hasPriceRange(Double minPrice, Double maxPrice) {
        return (root, query, criteriaBuilder) -> {
            if (minPrice != null && maxPrice != null) {
                return criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
            } else if (minPrice != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
            } else if (maxPrice != null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
            } else {
                return null;
            }
        };
    }

    public static Specification<Game> hasPlatform(String platform) {
        return (root, query, criteriaBuilder) ->
                platform == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("platform")), "%" + platform.toLowerCase() + "%");
    }

    public static Specification<Game> hasDeveloper(String developer) {
        return (root, query, criteriaBuilder) ->
                developer == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("developer")), "%" + developer.toLowerCase() + "%");
    }
}
