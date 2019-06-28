package ru.bakhuss.weather.web.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bakhuss.weather.core.model.Weather;
import ru.bakhuss.weather.core.service.WeatherService;
import ru.bakhuss.weather.web.controller.WeatherController;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/")
public class WeatherControllerImpl implements WeatherController {
    private final Logger log = LoggerFactory.getLogger(WeatherControllerImpl.class);

    @Value("${wwo.key}")
    private String key;
    @Value("#{'${cities}'.split(';')}")
    private List<String> cities;

    private WeatherService weatherService;

    @Autowired
    public WeatherControllerImpl(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override
    @GetMapping
    public String getWeather(Model model) {
        List<Weather> weathers = cities.stream()
                .map(c -> weatherService.getWeather(key, c))
                .collect(Collectors.toList());
        log.info(weathers.toString());

        model.addAttribute("weathers", weathers);
        model.addAttribute("time", weathers.get(0).getTime());
        model.addAttribute("service", weathers.get(0).getWeatherService());
        return "weather";
    }
}
