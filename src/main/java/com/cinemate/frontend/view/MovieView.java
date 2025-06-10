package com.cinemate.frontend.view;

import com.cinemate.frontend.client.MovieClient;
import com.cinemate.frontend.domain.MovieDto;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("movies")
public class MovieView extends VerticalLayout {

    private final MovieClient movieClient;

    private final Grid<MovieDto> grid = new Grid<>(MovieDto.class);
    private final TextField titleField = new TextField("Title");
    private final TextField directorField = new TextField("Director");
    private final TextField yearField = new TextField("Year");

    @Autowired
    public MovieView(MovieClient movieClient) {
        this.movieClient = movieClient;

        Button backButton = new Button("← Powrót do menu", e -> UI.getCurrent().navigate(""));
        backButton.getStyle()
                .set("marginBottom", "20px")
                .set("backgroundColor", "#95a5a6")
                .set("color", "white")
                .set("borderRadius", "6px");
        add(backButton);

        Button addButton = new Button("Add movie", e -> {
            try {
                MovieDto movie = new MovieDto(
                        null,
                        titleField.getValue(),
                        directorField.getValue(),
                        Integer.parseInt(yearField.getValue())
                );
                movieClient.createMovie(movie);
                Notification.show("Film dodany!");
                refresh();
                clearFields();
            } catch (NumberFormatException ex) {
                Notification.show("Rok musi być liczbą!");
            }
        });

        grid.removeAllColumns();
        grid.addColumn(MovieDto::getId).setHeader("ID");
        grid.addColumn(MovieDto::getTitle).setHeader("Tytuł");
        grid.addColumn(MovieDto::getDirector).setHeader("Reżyser");
        grid.addColumn(MovieDto::getYear).setHeader("Rok");

        grid.addComponentColumn(movie -> {
            Button deleteButton = new Button("Usuń", event -> {
                movieClient.deleteMovie(movie.getId());
                Notification.show("Usunięto film: " + movie.getTitle());
                refresh();
            });
            deleteButton.getStyle().set("color", "red");
            return deleteButton;
        }).setHeader("Akcje");

        add(titleField, directorField, yearField, addButton, grid);
        refresh();
    }

    private void refresh() {
        grid.setItems(movieClient.getAllMovies());
    }

    private void clearFields() {
        titleField.clear();
        directorField.clear();
        yearField.clear();
    }
}
