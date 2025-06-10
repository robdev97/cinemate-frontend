package com.cinemate.frontend.view;

import com.cinemate.frontend.client.UserClient;
import com.cinemate.frontend.domain.UserDto;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("users")
public class UserView extends VerticalLayout {

    private final UserClient userClient;

    private final Grid<UserDto> grid = new Grid<>(UserDto.class);
    private final TextField usernameField = new TextField("Username");
    private final TextField emailField = new TextField("Email");

    @Autowired
    public UserView(UserClient userClient) {
        this.userClient = userClient;


        Button backButton = new Button("← Powrót do menu", e -> UI.getCurrent().navigate(""));
        backButton.getStyle()
                .set("marginBottom", "20px")
                .set("backgroundColor", "#95a5a6")
                .set("color", "white")
                .set("borderRadius", "6px");
        add(backButton);

        Button addButton = new Button("Add user", e -> {
            UserDto user = new UserDto(
                    null,
                    usernameField.getValue(),
                    emailField.getValue()
            );
            userClient.createUser(user);
            refresh();
        });


        grid.addComponentColumn(user -> {
            Button deleteButton = new Button("Usuń", event -> {
                userClient.deleteUser(user.getId());
                Notification.show("Usunięto użytkownika: " + user.getUsername());
                refresh();
            });
            deleteButton.getStyle().set("color", "red");
            return deleteButton;
        }).setHeader("Akcje");

        add(usernameField, emailField, addButton, grid);
        refresh();
    }

    private void refresh() {
        grid.setItems(userClient.getAllUsers());
    }
}