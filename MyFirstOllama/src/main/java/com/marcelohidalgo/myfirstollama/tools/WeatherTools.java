package com.marcelohidalgo.myfirstollama.tools;

import org.springframework.ai.tool.annotation.Tool;

public class WeatherTools {

    @Tool(description = "Fetches the current weather conditions for a given city")
    public String getWeather(String city) {
        System.out.println("getWeather");
        return "The current weather in the " + city + "is 40 degrees with light winds";

    }

    @Tool(description = "Provides weather related advice based on the given weather condition")
    public String getWeatherAdvice(String weather) {
        System.out.println("getWeatherAdvice");

        if (weather.toLowerCase().contains("rain")) {
            return "Carry an umbrella! It is expected to rain";
        } else if (weather.toLowerCase().contains("cold")) {
            return "Wear warm clothes,Its going to be chilly";
        } else {
            return "Weather looks fine! Enjoy your day";
        }

    }

}
