package com.cinemate.frontend.client;

import com.cinemate.frontend.domain.ReviewDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class ReviewClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "http://localhost:8080/api/reviews";

    public List<ReviewDto> getAllReviews() {
        ReviewDto[] response = restTemplate.getForObject(BASE_URL, ReviewDto[].class);
        return Arrays.asList(response);
    }

    public void createReview(ReviewDto reviewDto) {
        restTemplate.postForObject(BASE_URL, reviewDto, ReviewDto.class);
    }
}
