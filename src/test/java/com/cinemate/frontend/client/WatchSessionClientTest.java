package com.cinemate.frontend.client;

import com.cinemate.frontend.domain.WatchSessionDto;
import org.junit.jupiter.api.Test;

import javax.annotation.meta.When;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WatchSessionClientTest {

    private final WatchSessionClient watchSessionClient = new WatchSessionClient();

    @Test
    void shouldFetchMockedWatchSessions() {
        //When
        List<WatchSessionDto> sessions = watchSessionClient.fetchWatchSessions();
        //Then
        assertNotNull(sessions);
        assertEquals(2, sessions.size());

        WatchSessionDto first = sessions.get(0);
        assertEquals("Inception", first.getMovieTitle());
        assertEquals("robert_dev", first.getHostUsername());
        assertNotNull(first.getScheduledDateTime());
        assertEquals("Planned", first.getStatus());
    }
}
