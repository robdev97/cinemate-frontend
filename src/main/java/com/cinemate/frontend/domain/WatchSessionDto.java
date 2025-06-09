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
public class WatchSessionDto {
    private Long id;
    private String movieTitle;
    private String hostUsername;
    private LocalDateTime scheduledDateTime;
    private String status;
}
