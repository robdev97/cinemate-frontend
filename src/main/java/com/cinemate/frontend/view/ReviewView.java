package com.cinemate.frontend.view;

import com.cinemate.frontend.client.ReviewClient;
import com.cinemate.frontend.domain.ReviewDto;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Route("reviews")
public class ReviewView extends VerticalLayout {

    private final ReviewClient reviewClient;
    private final Grid<ReviewDto> grid = new Grid<>(ReviewDto.class);

    private final TextField userIdField = new TextField("User ID");
    private final TextField movieIdField = new TextField("Movie ID");
    private final TextField ratingField = new TextField("Rating");
    private final TextArea contentField = new TextArea("Content");

    @Autowired
    public ReviewView(ReviewClient reviewClient) {
        this.reviewClient = reviewClient;


        Button backButton = new Button("← Powrót do menu", e -> UI.getCurrent().navigate(""));
        backButton.getStyle()
                .set("marginBottom", "20px")
                .set("backgroundColor", "#95a5a6")
                .set("color", "white")
                .set("borderRadius", "6px");
        add(backButton);

        Button addButton = new Button("Add review", e -> {
            ReviewDto review = new ReviewDto(
                    null,
                    Long.parseLong(userIdField.getValue()),
                    Long.parseLong(movieIdField.getValue()),
                    Integer.parseInt(ratingField.getValue()),
                    contentField.getValue(),
                    LocalDateTime.now()
            );
            reviewClient.createReview(review);
            refresh();
        });

        grid.removeAllColumns();
        grid.addColumn(ReviewDto::getId).setHeader("ID");
        grid.addColumn(ReviewDto::getUserId).setHeader("User ID");
        grid.addColumn(ReviewDto::getMovieId).setHeader("Movie ID");
        grid.addColumn(ReviewDto::getRating).setHeader("Ocena");
        grid.addColumn(ReviewDto::getContent).setHeader("Treść");
        grid.addColumn(review -> review.getCreatedAt().toString()).setHeader("Utworzono");

        add(userIdField, movieIdField, ratingField, contentField, addButton, grid);
        refresh();
    }

    private void refresh() {
        grid.setItems(reviewClient.getAllReviews());
    }
}