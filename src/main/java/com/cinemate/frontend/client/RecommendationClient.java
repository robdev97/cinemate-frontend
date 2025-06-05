package com.cinemate.frontend.client;

import com.cinemate.frontend.domain.RecommendationDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecommendationClient {

    public List<RecommendationDto> fetchRecommendations() {
        return List.of(
                new RecommendationDto("Inception", "based on your favorite director"),
                new RecommendationDto("Blade Runner 2049", "popular among your friends"),
                new RecommendationDto("Arrival", "Sci-Fi genre match")
        );
    }
}