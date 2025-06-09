package com.cinemate.frontend.client;

import com.cinemate.frontend.domain.WatchSessionDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class WatchSessionClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String backendUrl = "http://localhost:8080/api/sessions";

    public List<WatchSessionDto> fetchWatchSessions() {
        WatchSessionDto[] sessions = restTemplate.getForObject(backendUrl, WatchSessionDto[].class);
        return Arrays.asList(sessions);
    }
}
