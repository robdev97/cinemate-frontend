package com.cinemate.frontend.client;

import com.cinemate.frontend.domain.FriendDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FriendClient {

    public List<FriendDto> fetchFriends() {
        return List.of(
                new FriendDto(1L, 1L, 2L, "ACCEPTED"),
                new FriendDto(2L, 2L, 3L, "PENDING")
        );
    }
}