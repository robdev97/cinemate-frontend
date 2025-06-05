package com.cinemate.frontend.client;

import com.cinemate.frontend.domain.ReviewDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReviewClientTest {

    private final ReviewClient reviewClient = new ReviewClient();

    @Test
    void shouldFetchReviews() {
        List<ReviewDto> reviews = reviewClient.fetchReviews();

        assertNotNull(reviews);
        assertEquals(3, reviews.size());

        ReviewDto review = reviews.get(0);
        assertEquals("robert_dev", review.getUsername());
        assertEquals(9, review.getRating());
        assertTrue(review.getComment().contains("Great movie with mind-bending plot."));
    }
}