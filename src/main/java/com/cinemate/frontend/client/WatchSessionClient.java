package com.cinemate.frontend.client;

import com.cinemate.frontend.domain.WatchSessionDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class WatchSessionClient {

    public List<WatchSessionDto> fetchWatchSessions() {
        return List.of(
                new WatchSessionDto(1L, "Inception", "robert_dev", LocalDateTime.of(2025, 6, 10, 20, 0), "Planned"),
                new WatchSessionDto(2L, "Pulp Fiction", "anita_film", LocalDateTime.of(2025, 6, 11, 21, 30), "Completed")
        );
    }
}
