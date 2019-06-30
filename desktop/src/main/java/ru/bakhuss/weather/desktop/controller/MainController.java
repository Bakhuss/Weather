package ru.bakhuss.weather.desktop.controller;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ru.bakhuss.weather.desktop.ApplicationDesktop;

public class MainController {
    public TextField tFieldFrom;
    public TextArea tAreaMain;
    private ApplicationDesktop applicationDesktop;


    public void setApplicationDesktop(ApplicationDesktop applicationDesktop) {
        this.applicationDesktop = applicationDesktop;
    }
}
