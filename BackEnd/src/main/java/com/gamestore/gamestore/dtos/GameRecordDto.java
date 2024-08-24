package com.gamestore.gamestore.dtos;

import java.util.List;

public record GameRecordDto(String name, List<String> images, String category, String description, String platform, Double price, String ageRating, Integer releaseDate, String developer, String publisher, Double rating) {
}
