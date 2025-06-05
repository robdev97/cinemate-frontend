package com.cinemate.frontend.view;


import com.cinemate.frontend.client.UserClient;
import com.cinemate.frontend.domain.UserDto;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("users")
public class UserView extends VerticalLayout {

    private final UserClient userClient;
    private final Grid<UserDto> userGrid = new Grid<>(UserDto.class);

    @Autowired
    public UserView(final UserClient userClient) {
        this.userClient = userClient;

        userGrid.setColumns("id", "username", "email", "favoriteGenre");
        userGrid.setItems(userClient.fetchUsers());

        add(userGrid);
    }
}
