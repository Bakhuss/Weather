package ru.bakhuss.weather.core.service;

import ru.bakhuss.weather.core.model.Weather;

public interface WeatherService {
    Weather getWeather(String key, String city);
}
