package ru.bakhuss.weather.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.bakhuss.weather.core.service.WeatherService;
import ru.bakhuss.weather.core.service.impl.WorldWeatherOnlineServiceImpl;

@SpringBootApplication
public class ApplicationWeb {

    @Bean
    public WeatherService weatherService() {
        return new WorldWeatherOnlineServiceImpl();
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationWeb.class, args);
    }
}
