package com.cinemate.frontend.client;

import com.cinemate.frontend.domain.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class UserClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "http://localhost:8080/api/users";

    public List<UserDto> getAllUsers() {
        UserDto[] response = restTemplate.getForObject(BASE_URL, UserDto[].class);
        return Arrays.asList(response);
    }

    public void createUser(UserDto userDto) {
        restTemplate.postForObject(BASE_URL, userDto, UserDto.class);
    }
    public void deleteUser(Long userId) {
        restTemplate.delete(BASE_URL + "/" + userId);
    }
}
