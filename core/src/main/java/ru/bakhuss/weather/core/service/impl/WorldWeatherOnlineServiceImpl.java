package ru.bakhuss.weather.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.bakhuss.weather.core.model.Weather;
import ru.bakhuss.weather.core.model.worldweatheronline.CurrentCondition;
import ru.bakhuss.weather.core.model.worldweatheronline.WWO;
import ru.bakhuss.weather.core.service.WeatherService;

@Service
public class WorldWeatherOnlineServiceImpl implements WeatherService {
    private final Logger log = LoggerFactory.getLogger(WorldWeatherOnlineServiceImpl.class);

    private final String BASE_URL = "https://www.worldweatheronline.com/";
    private final String BASE_URL_WEATHER = "http://api.worldweatheronline.com/premium/v1/weather.ashx";
    private String date = "today";
    private String format = "json";

    private String URL = BASE_URL_WEATHER + "?"
            + "&format=" + format
            + "&date=" + date
            + "&fx=no&mca=no&lang=ru";

    @Override
    public Weather getWeather(String key, String city) {
        StringBuilder sBuilder = new StringBuilder(URL);
        RestTemplate template = new RestTemplate();

        ResponseEntity<WWO> forEntity = template.getForEntity(
                sBuilder.append("&key=").append(key)
                        .append("&q=").append(city)
                        .toString(),
                WWO.class);

        if (forEntity.getBody() == null)
            throw new RuntimeException("Data not response");

        CurrentCondition condition = forEntity.getBody()
                .getData().getCurrent_condition()[0];
        log.info("info: \n" + condition);

        Weather weather = new Weather();
        weather.setWeatherService(BASE_URL);
        weather.setCity(forEntity.getBody().getData().getRequest()[0].getQuery());
        weather.setTime(condition.getObservation_time());
        weather.setTemp(condition.getTemp_C());
        weather.setHumidity(condition.getHumidity());
        weather.setWindSpeedKmph(condition.getWindspeedKmph());
        weather.setPressure(condition.getPressure());
        weather.setWeatherDesc(condition.getLang_ru()[0].getValue());
        return weather;
    }
}
