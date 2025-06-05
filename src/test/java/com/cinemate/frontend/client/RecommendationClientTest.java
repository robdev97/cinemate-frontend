package com.cinemate.frontend.client;

import com.cinemate.frontend.domain.RecommendationDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecommendationClientTest {

    private final RecommendationClient recommendationClient = new RecommendationClient();

    @Test
    void shouldFetchRecommendations() {
        List<RecommendationDto> recommendations = recommendationClient.fetchRecommendations();

        assertNotNull(recommendations);
        assertEquals(3, recommendations.size());

        RecommendationDto rec = recommendations.get(1);
        assertEquals("Blade Runner 2049", rec.getMovieTitle());
        assertEquals("popular among your friends", rec.getReason());
    }
}