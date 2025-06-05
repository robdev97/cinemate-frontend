package com.cinemate.frontend.client;

import com.cinemate.frontend.domain.MovieDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieClient {
    public List<MovieDto> fetchMovies() {
        List<MovieDto> movies = new ArrayList<>();

        movies.add(new MovieDto(1L, "Inception", "Christopher Nolan", 2010));
        movies.add(new MovieDto(2L, "The Matrix", "Wachowskis", 1999));
        movies.add(new MovieDto(3L, "Interstellar", "Christopher Nolan", 2014));
        movies.add(new MovieDto(4L, "The Godfather", "Francis Ford Coppola", 1972));
        movies.add(new MovieDto(5L, "Pulp Fiction", "Quentin Tarantino", 1994));

        return movies;
    }
}
