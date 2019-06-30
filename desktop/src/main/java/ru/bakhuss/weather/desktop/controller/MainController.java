package ru.bakhuss.weather.desktop.controller;

import javafx.scene.control.Button;
import ru.bakhuss.weather.desktop.ApplicationDesktop;

public class MainController {

    private ApplicationDesktop applicationDesktop;

    public void setApplicationDesktop(ApplicationDesktop applicationDesktop) {
        this.applicationDesktop = applicationDesktop;
    }

    public Button load;
}
