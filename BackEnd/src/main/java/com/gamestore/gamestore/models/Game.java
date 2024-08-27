package com.gamestore.gamestore.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.Double;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "games")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private List<String> images;
    private List<String> category;
    private String description;
    private List<String> platform;
    private Double price;
    private Integer ageRating;
    private Integer releaseYear;
    private String developer;
    private String publisher;
    private Double rating;

}
