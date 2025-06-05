package com.cinemate.frontend.view;

import com.cinemate.frontend.client.RecommendationClient;
import com.cinemate.frontend.domain.RecommendationDto;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("recommendations")
public class RecommendationView extends VerticalLayout {

    private final Grid<RecommendationDto> recommendationGrid = new Grid<>(RecommendationDto.class);

    @Autowired
    public RecommendationView(RecommendationClient recommendationClient) {
        recommendationGrid.setColumns("movieTitle", "reason");
        recommendationGrid.setItems(recommendationClient.fetchRecommendations());
        add(recommendationGrid);
    }
}