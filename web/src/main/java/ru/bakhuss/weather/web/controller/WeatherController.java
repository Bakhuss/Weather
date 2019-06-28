package ru.bakhuss.weather.web.controller;

import org.springframework.ui.Model;

public interface WeatherController {
    String getWeather(Model model);
}
