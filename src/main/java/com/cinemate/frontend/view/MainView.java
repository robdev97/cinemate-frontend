package com.cinemate.frontend.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        setSpacing(true);
        setPadding(true);
        setAlignItems(Alignment.CENTER);

        H1 heading = new H1("🎬 CineMate");
        heading.getStyle()
                .set("color", "#2c3e50")
                .set("fontSize", "40px")
                .set("marginBottom", "10px");


        Paragraph description = new Paragraph("Zarządzaj filmami, użytkownikami i sesjami oglądania. Wybierz sekcję poniżej:");
        description.getStyle().set("fontSize", "18px");


        Button moviesBtn = new Button("🎥 Filmy", e -> UI.getCurrent().navigate("movies"));
        Button usersBtn = new Button("👤 Użytkownicy", e -> UI.getCurrent().navigate("users"));
        Button reviewsBtn = new Button("⭐ Recenzje", e -> UI.getCurrent().navigate("reviews"));
        Button sessionsBtn = new Button("🕒 Sesje Oglądania", e -> UI.getCurrent().navigate("sessions"));


        for (Button btn : new Button[]{moviesBtn, usersBtn, reviewsBtn, sessionsBtn}) {
            btn.getStyle()
                    .set("fontSize", "16px")
                    .set("padding", "10px 20px")
                    .set("margin", "10px")
                    .set("backgroundColor", "#3498db")
                    .set("color", "white")
                    .set("borderRadius", "8px")
                    .set("border", "none")
                    .set("cursor", "pointer");
        }


        VerticalLayout buttonLayout = new VerticalLayout(moviesBtn, usersBtn, reviewsBtn, sessionsBtn);
        buttonLayout.setAlignItems(Alignment.CENTER);

        add(heading, description, buttonLayout);
    }
}