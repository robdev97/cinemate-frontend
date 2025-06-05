package com.cinemate.frontend.client;

import com.cinemate.frontend.domain.FriendDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FriendClient {

    public List<FriendDto> fetchFriends() {
        return List.of(
                new FriendDto(1L, "anita_film", "anita@example.com"),
                new FriendDto(2L, "movie_buff", "buff@example.com")
        );
    }
}