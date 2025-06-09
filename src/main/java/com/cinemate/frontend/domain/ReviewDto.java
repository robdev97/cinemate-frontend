package com.cinemate.frontend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private Long id;
    private Long movieId;
    private Long userId;
    private String content;
    private int rating;
    private LocalDateTime createdAt;

    private String movieTitle;
    private String username;

    public ReviewDto(String username, String movieTitle, int rating, String content) {
        this.username = username;
        this.movieTitle = movieTitle;
        this.rating = rating;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }
}