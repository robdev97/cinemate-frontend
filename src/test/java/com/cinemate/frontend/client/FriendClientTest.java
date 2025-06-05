package com.cinemate.frontend.client;

import com.cinemate.frontend.domain.FriendDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FriendClientTest {

    private final FriendClient friendClient = new FriendClient();

    @Test
    void shouldFetchFriends() {
        List<FriendDto> friends = friendClient.fetchFriends();

        assertNotNull(friends);
        assertEquals(2, friends.size());

        FriendDto friend = friends.get(0);
        assertEquals("anita_film", friend.getUsername());
        assertEquals("anita@example.com", friend.getEmail());
    }
}