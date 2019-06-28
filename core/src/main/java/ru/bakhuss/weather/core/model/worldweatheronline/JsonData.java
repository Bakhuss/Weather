package ru.bakhuss.weather.core.model.worldweatheronline;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class JsonData {
    City[] request;
    CurrentCondition[] current_condition;
}
