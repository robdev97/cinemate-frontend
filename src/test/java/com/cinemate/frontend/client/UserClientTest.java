package com.cinemate.frontend.client;

import com.cinemate.frontend.domain.UserDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserClientTest {

    private final UserClient userClient = new UserClient();

    @Test
    void shouldFetchMockedUsers() {
        //When
        List<UserDto> users = userClient.fetchUsers();
        //Then
        assertNotNull(users);
        assertEquals(3, users.size());

        UserDto first = users.get(0);
        assertEquals(1L, first.getId());
        assertEquals("robert_dev", first.getUsername());
        assertEquals("robert@example.com", first.getEmail());
        assertEquals("Sci-Fi", first.getFavoriteGenre());
    }
}
