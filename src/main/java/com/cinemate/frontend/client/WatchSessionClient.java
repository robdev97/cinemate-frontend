package com.cinemate.frontend.client;

import com.cinemate.frontend.domain.WatchSessionDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class WatchSessionClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "http://localhost:8080/api/watch-sessions";

    public List<WatchSessionDto> getAllSessions() {
        WatchSessionDto[] response = restTemplate.getForObject(BASE_URL, WatchSessionDto[].class);
        return Arrays.asList(response);
    }

    public void createSession(WatchSessionDto sessionDto) {
        restTemplate.postForObject(BASE_URL, sessionDto, WatchSessionDto.class);
    }

    public void deleteSession(Long id) {
        restTemplate.delete(BASE_URL + "/" + id);
    }

    public void updateSession(Long id, WatchSessionDto sessionDto) {
        HttpEntity<WatchSessionDto> requestEntity = new HttpEntity<>(sessionDto);
        restTemplate.exchange(BASE_URL + "/" + id, HttpMethod.PUT, requestEntity, Void.class);
    }
}