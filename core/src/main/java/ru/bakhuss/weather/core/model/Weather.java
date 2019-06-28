package ru.bakhuss.weather.core.model;

import lombok.Data;

@Data
public class Weather {
    private String weatherService;

    private String city;

    private String time;

    private Integer temp;

    private Float humidity;

    private Integer windSpeedKmph;

    private Integer pressure;

    String weatherDesc;
}
