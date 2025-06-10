package com.cinemate.frontend;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@PWA(name = "CineMate", shortName = "CineMate")
public class CinemateFrontendApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(CinemateFrontendApplication.class, args);
    }
}