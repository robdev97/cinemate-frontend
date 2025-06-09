package com.cinemate.frontend.view;


import com.cinemate.frontend.client.UserClient;
import com.cinemate.frontend.domain.UserDto;
import com.cinemate.frontend.layout.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "users", layout = MainLayout.class)
public class UserView extends VerticalLayout {

    private final UserClient userClient;
    private final Grid<UserDto> userGrid = new Grid<>(UserDto.class);

    @Autowired
    public UserView(final UserClient userClient) {
        this.userClient = userClient;

        userGrid.setColumns("id", "username", "password", "email", "fullName");
        userGrid.setItems(userClient.fetchUsers());

        add(userGrid);
    }
}
