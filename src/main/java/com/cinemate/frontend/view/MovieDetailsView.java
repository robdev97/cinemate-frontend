package com.cinemate.frontend.view;

import com.cinemate.frontend.client.ReviewClient;
import com.cinemate.frontend.domain.ReviewDto;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("movie-details")
public class MovieDetailsView extends VerticalLayout {

    private final Grid<ReviewDto> reviewGrid = new Grid<>(ReviewDto.class);

    @Autowired
    public MovieDetailsView(ReviewClient reviewClient) {
        reviewGrid.setColumns("username", "movieTitle", "rating", "comment");
        reviewGrid.setItems(reviewClient.fetchReviews());
        add(reviewGrid);
    }
}