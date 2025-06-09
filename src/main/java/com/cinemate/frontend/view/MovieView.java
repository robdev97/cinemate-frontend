package com.cinemate.frontend.view;

import com.cinemate.frontend.client.MovieClient;
import com.cinemate.frontend.domain.MovieDto;
import com.cinemate.frontend.layout.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "movies", layout = MainLayout.class)
public class MovieView extends VerticalLayout {

    private final MovieClient movieClient;
    private final Grid<MovieDto> movieGrid = new Grid<>(MovieDto.class);

    @Autowired
    public MovieView(MovieClient movieClient) {
        this.movieClient = movieClient;

        movieGrid.setColumns("id", "title", "genre", "releaseYear", "rating", "description");
        movieGrid.setItems(movieClient.fetchMovies());

        add(movieGrid);
    }
}

