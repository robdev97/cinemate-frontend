package com.cinemate.frontend.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WatchSessionDto {
    private Long id;
    private Long movieId;
    private String movieTitle;
    private LocalDateTime scheduledAt;
    private String location;
}
