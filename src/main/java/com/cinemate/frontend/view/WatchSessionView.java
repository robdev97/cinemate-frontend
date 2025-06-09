package com.cinemate.frontend.view;

import com.cinemate.frontend.client.WatchSessionClient;
import com.cinemate.frontend.domain.WatchSessionDto;
import com.cinemate.frontend.layout.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;

@Route(value = "sessions", layout = MainLayout.class)
public class WatchSessionView extends VerticalLayout {

    private final WatchSessionClient sessionClient;
    private final Grid<WatchSessionDto> sessionGrid = new Grid<>(WatchSessionDto.class);

    @Autowired
    public WatchSessionView(WatchSessionClient sessionClient) {
        this.sessionClient = sessionClient;

        sessionGrid.removeAllColumns();

        sessionGrid.addColumn(WatchSessionDto::getId).setHeader("ID");
        sessionGrid.addColumn(WatchSessionDto::getMovieTitle).setHeader("Movie Title");
        sessionGrid.addColumn(WatchSessionDto::getHostUsername).setHeader("Host");


        sessionGrid.addColumn(session ->
                session.getScheduledDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
        ).setHeader("Scheduled Time");

        sessionGrid.addColumn(WatchSessionDto::getStatus).setHeader("Status");

        sessionGrid.setItems(sessionClient.fetchWatchSessions());

        add(sessionGrid);
    }
}
