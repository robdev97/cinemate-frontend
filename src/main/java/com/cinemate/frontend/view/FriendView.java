package com.cinemate.frontend.view;

import com.cinemate.frontend.client.FriendClient;
import com.cinemate.frontend.domain.FriendDto;
import com.cinemate.frontend.layout.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "friends", layout = MainLayout.class)
public class FriendView extends VerticalLayout {


    private final Grid<FriendDto> friendGrid = new Grid<>(FriendDto.class);

    @Autowired
    public FriendView(FriendClient friendClient) {
        friendGrid.setColumns("id", "userId", "friendUserId", "status");
        friendGrid.setItems(friendClient.fetchFriends());
        add(friendGrid);
    }
}