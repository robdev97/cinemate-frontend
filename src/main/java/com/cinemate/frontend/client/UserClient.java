package com.cinemate.frontend.client;


import com.cinemate.frontend.domain.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserClient {

    public List<UserDto> fetchUsers() {
        List<UserDto> users = new ArrayList<>();

        users.add(new UserDto(1L, "robert_dev", "robert@example.com", "Sci-Fi"));
        users.add(new UserDto(2L, "anita_film", "anita@example.com", "Thriller"));
        users.add(new UserDto(3L, "movie_buff", "buff@example.com", "Drama"));

        return users;
    }
}
