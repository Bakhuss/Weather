package ru.bakhuss.weather.core.model.worldweatheronline;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CurrentCondition {
    String observation_time;
    Integer temp_C;
    Integer windspeedKmph;
    Float humidity;
    Integer pressure;
    WeatherDesc[] lang_ru;
}
