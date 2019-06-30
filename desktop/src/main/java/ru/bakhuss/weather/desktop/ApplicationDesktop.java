package ru.bakhuss.weather.desktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bakhuss.weather.core.model.Weather;
import ru.bakhuss.weather.core.service.WeatherService;
import ru.bakhuss.weather.core.service.impl.WorldWeatherOnlineServiceImpl;
import ru.bakhuss.weather.desktop.controller.MainController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationDesktop extends Application {
    private final Logger log = LoggerFactory.getLogger(ApplicationDesktop.class);
    private Stage primaryStage;
    private String key = "b0372e1b8ce9424ea30134444192206";
    private List<String> cities = Arrays.asList("Moscow,Russia", "Saint Petersburg,Russia", "Tokyo,Japan");

    public ApplicationDesktop() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        method();
    }

    public void method() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ApplicationDesktop.class.getResource("/view/fxml/main.fxml"));
            AnchorPane mainView = (AnchorPane) loader.load();
            Scene scene = new Scene(mainView);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Weather");
            primaryStage.show();

            MainController controller = loader.getController();
            controller.setApplicationDesktop(this);

            WeatherService weatherService = new WorldWeatherOnlineServiceImpl();
            List<Weather> weathers = cities.stream()
                    .map(c -> weatherService.getWeather(key, c))
                    .collect(Collectors.toList());
            log.info(weathers.toString());

            controller.tFieldFrom.appendText(" " + weathers.get(0).getWeatherService());
            controller.tAreaMain.setText("");
            weathers.forEach(w -> controller.tAreaMain.appendText(w.toString() + "\n\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
