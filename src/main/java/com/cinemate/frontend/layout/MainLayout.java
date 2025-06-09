package com.cinemate.frontend.layout;

import com.cinemate.frontend.view.*;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;

@PageTitle("CineMate")
public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("🎬 CineMate");
        logo.getStyle()
                .set("font-size", "1.5em")
                .set("margin", "0");

        HorizontalLayout header = new HorizontalLayout(logo);
        header.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        header.setWidthFull();
        header.getStyle()
                .set("background-color", "#2c3e50")
                .set("color", "white")
                .set("padding", "1em");

        addToNavbar(header);
    }

    private void createDrawer() {
        RouterLink movies = new RouterLink("Movies", MovieView.class);
        RouterLink users = new RouterLink("Users", UserView.class);
        RouterLink friends = new RouterLink("Friends", FriendView.class);
        RouterLink sessions = new RouterLink("Watch Sessions", WatchSessionView.class);
        RouterLink recommendations = new RouterLink("Recommendations", RecommendationView.class);

        Button logoutButton = new Button("Logout", e -> UI.getCurrent().navigate("login"));
        logoutButton.getStyle().set("margin-top", "1em");

        VerticalLayout drawerLayout = new VerticalLayout(
                movies, users, friends, sessions, recommendations, logoutButton
        );
        drawerLayout.setSpacing(false);
        drawerLayout.setPadding(true);

        addToDrawer(drawerLayout);
    }
}