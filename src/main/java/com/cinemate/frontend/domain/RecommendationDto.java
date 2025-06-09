package com.cinemate.frontend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.cinemate.frontend.domain.enums.RecommendationStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationDto {

    private Long id;
    private Long userId;
    private Long movieId;
    private String reason;
    private RecommendationStatus status;

    public RecommendationDto(String reason) {
        this.id = null;
        this.userId = null;
        this.movieId = null;
        this.reason = reason;
        this.status = null;
    }
}
