package com.gamestore.gamestore.dtos;

import java.util.List;

public record GameRecordDto(String name, List<String> images, List<String> category, String description, List<String> platform, Double price, Integer ageRating, Integer releaseYear, String developer, String publisher, Double rating) {
}
