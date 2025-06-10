package com.cinemate.frontend.view;

import com.cinemate.frontend.client.WatchSessionClient;
import com.cinemate.frontend.domain.WatchSessionDto;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Route("sessions")
public class WatchSessionView extends VerticalLayout {

    private final WatchSessionClient sessionClient;
    private final Grid<WatchSessionDto> grid = new Grid<>(WatchSessionDto.class);

    private final TextField movieIdField = new TextField("Movie ID");
    private final DateTimePicker scheduledAtField = new DateTimePicker("Scheduled At");
    private final TextField locationField = new TextField("Location");

    private Long editingSessionId = null;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Autowired
    public WatchSessionView(WatchSessionClient sessionClient) {
        this.sessionClient = sessionClient;

        setSpacing(true);
        setPadding(true);

        H1 header = new H1("Planowanie wspólnych seansów");
        header.getStyle().set("marginBottom", "0");
        add(header);


        Button backButton = new Button("← Powrót do menu", e -> UI.getCurrent().navigate(""));
        backButton.getStyle()
                .set("marginBottom", "20px")
                .set("backgroundColor", "#95a5a6")
                .set("color", "white")
                .set("borderRadius", "6px");
        add(backButton);


        Button addButton = new Button("Zapisz sesję", e -> {
            try {
                WatchSessionDto session = new WatchSessionDto(
                        editingSessionId,
                        Long.parseLong(movieIdField.getValue()),
                        null,
                        scheduledAtField.getValue(),
                        locationField.getValue()

                );

                if (editingSessionId == null) {
                    sessionClient.createSession(session);
                    Notification.show("Dodano nową sesję!");
                } else {
                    sessionClient.updateSession(session.getId(), session);
                    Notification.show("Zaktualizowano sesję!");
                    editingSessionId = null;
                }

                refresh();
                clearFields();

            } catch (Exception ex) {
                Notification.show("Błąd danych: " + ex.getMessage());
            }
        });

        HorizontalLayout formLayout = new HorizontalLayout(movieIdField, scheduledAtField, locationField, addButton);
        formLayout.setSpacing(true);
        add(formLayout);


        grid.removeAllColumns();
        grid.addColumn(WatchSessionDto::getId).setHeader("ID");
        grid.addColumn(WatchSessionDto::getMovieTitle).setHeader("Movie Title");
        grid.addColumn(session -> {
            LocalDateTime scheduled = session.getScheduledAt();
            return scheduled != null
                    ? scheduled.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                    : "Not scheduled";
        }).setHeader("Scheduled At");
        grid.addColumn(WatchSessionDto::getLocation).setHeader("Location");

        grid.addComponentColumn(session -> {
            Button editButton = new Button("Edytuj", click -> {
                movieIdField.setValue(session.getMovieId().toString());
                scheduledAtField.setValue(session.getScheduledAt());
                locationField.setValue(session.getLocation());
                editingSessionId = session.getId();
            });

            Button deleteButton = new Button("Usuń", click -> {
                sessionClient.deleteSession(session.getId());
                Notification.show("Sesja usunięta!");
                refresh();
            });
            deleteButton.getStyle().set("color", "red");

            return new HorizontalLayout(editButton, deleteButton);
        }).setHeader("Akcje");

        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        grid.setWidthFull();
        add(grid);

        refresh();
    }

    private void refresh() {
        grid.setItems(sessionClient.getAllSessions());
    }

    private void clearFields() {
        movieIdField.clear();
        scheduledAtField.clear();
        locationField.clear();
    }
}