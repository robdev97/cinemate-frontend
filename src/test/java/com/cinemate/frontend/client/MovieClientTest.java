package com.cinemate.frontend.client;

import com.cinemate.frontend.domain.MovieDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MovieClientTest {

    private final MovieClient movieClient = new MovieClient();

    @Test
    void shouldFetchMockedMovie() {
        //When
        List<MovieDto> movies = movieClient.fetchMovies();
        //Then
        assertEquals(5, movies.size());
        assertEquals("Inception", movies.get(0).getTitle());
        assertEquals(2010, movies.get(0).getReleaseYear());
    }
}
