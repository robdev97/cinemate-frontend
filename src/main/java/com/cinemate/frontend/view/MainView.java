package com.cinemate.frontend.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.router.PageTitle;

@Route("main")
@PageTitle("CineMate | Home")
public class MainView extends VerticalLayout {

    public MainView() {
        setSizeFull();
        setPadding(true);
        setSpacing(true);

        H1 title = new H1("CineMate");

        HorizontalLayout menu = new HorizontalLayout();
        menu.setSpacing(true);

        // Linki do podstron
        RouterLink moviesLink = new RouterLink("Filmy", MovieView.class);
        RouterLink usersLink = new RouterLink("Użytkownicy", UserView.class);
        RouterLink friendsLink = new RouterLink("Znajomi", FriendView.class);
        RouterLink sessionsLink = new RouterLink("Seanse", WatchSessionView.class);
        RouterLink recommendationsLink = new RouterLink("Rekomendacje", RecommendationView.class);

        Button logoutButton = new Button("Wyloguj", event ->
                UI.getCurrent().navigate("login")
        );

        menu.add(moviesLink, usersLink, friendsLink, sessionsLink, recommendationsLink, logoutButton);

        add(title, menu);
    }
}