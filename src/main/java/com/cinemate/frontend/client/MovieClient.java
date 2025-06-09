package com.cinemate.frontend.client;

import com.cinemate.frontend.domain.MovieDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class MovieClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String backendUrl = "http://localhost:8080/api/movies";

    public List<MovieDto> fetchMovies() {
        MovieDto[] movies = restTemplate.getForObject(backendUrl, MovieDto[].class);
        return Arrays.asList(movies);
    }
}