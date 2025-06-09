package com.cinemate.frontend.client;

import com.cinemate.frontend.domain.RecommendationDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecommendationClient {

    public List<RecommendationDto> fetchRecommendations() {
        return List.of(
                new RecommendationDto("Based on your favorite director"),
                new RecommendationDto("Popular among your friends"),
                new RecommendationDto("Sci-Fi genre match")
        );
    }
}