package com.cinemate.frontend.client;

import com.cinemate.frontend.domain.ReviewDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReviewClient {

    public List<ReviewDto> fetchReviews() {
        return List.of(
                new ReviewDto("robert_dev", "Inception", 9, "Great movie with mind-bending plot."),
                new ReviewDto("anita_film", "Inception", 8, "Amazing visuals and story."),
                new ReviewDto("movie_buff", "Inception", 10, "Masterpiece.")
        );
    }
}