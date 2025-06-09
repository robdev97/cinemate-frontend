package com.cinemate.frontend.view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;


@Route("login")
@PageTitle("Login | CineMate")
public class LoginView extends VerticalLayout {

    public LoginView() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        H1 header = new H1("CineMate");
        LoginForm loginForm = new LoginForm();
        loginForm.setI18n(createPolishI18n());
        loginForm.addLoginListener(event -> {
            // Tu normalnie byłaby autentykacja — uproszczona wersja:
            String username = event.getUsername();
            String password = event.getPassword();

            // Pseudologika — dla testów logujemy każdego
            if (!username.isEmpty() && !password.isEmpty()) {
                loginForm.setEnabled(false);
                getUI().ifPresent(ui -> ui.navigate("main")); // po zalogowaniu
            } else {
                loginForm.setError(true);
            }
        });

        add(header, loginForm);
    }

    private LoginI18n createPolishI18n() {
        LoginI18n i18n = LoginI18n.createDefault();
        i18n.setHeader(new LoginI18n.Header());
        i18n.getHeader().setTitle("CineMate");
        i18n.getHeader().setDescription("Logowanie do platformy filmowej");
        i18n.getForm().setUsername("Nazwa użytkownika");
        i18n.getForm().setTitle("Logowanie");
        i18n.getForm().setPassword("Hasło");
        i18n.getForm().setSubmit("Zaloguj");
        i18n.getForm().setForgotPassword("Nie pamiętasz hasła?");
        i18n.getErrorMessage().setTitle("Nieprawidłowe dane logowania");
        i18n.getErrorMessage().setMessage("Sprawdź nazwę użytkownika i hasło");
        return i18n;
    }
}