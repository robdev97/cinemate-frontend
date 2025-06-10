package com.cinemate.frontend.client;

import com.cinemate.frontend.domain.MovieDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "http://localhost:8080/api/movies";

    public List<MovieDto> getAllMovies() {
        MovieDto[] response = restTemplate.getForObject(BASE_URL, MovieDto[].class);
        return Arrays.asList(response);
    }

    public void createMovie(MovieDto movieDto) {
        restTemplate.postForObject(BASE_URL, movieDto, MovieDto.class);
    }

    public void deleteMovie(Long movieId) {
        restTemplate.delete(BASE_URL + "/" + movieId);
    }
}