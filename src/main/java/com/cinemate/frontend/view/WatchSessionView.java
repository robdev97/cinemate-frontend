package com.cinemate.frontend.view;

import com.cinemate.frontend.client.WatchSessionClient;
import com.cinemate.frontend.domain.WatchSessionDto;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("sessions")
public class WatchSessionView extends VerticalLayout {

    private final WatchSessionClient sessionClient;
    private final Grid<WatchSessionDto> sessionGrid = new Grid<>(WatchSessionDto.class);

    @Autowired
    public WatchSessionView(WatchSessionClient sessionClient) {
        this.sessionClient = sessionClient;

        sessionGrid.setColumns("id", "movieTitle", "hostUsername", "scheduledDateTime", "status");
        sessionGrid.setItems(sessionClient.fetchWatchSessions());

        add(sessionGrid);
    }
}
