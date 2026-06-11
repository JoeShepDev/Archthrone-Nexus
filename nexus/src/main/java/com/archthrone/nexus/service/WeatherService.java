package com.archthrone.nexus.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.archthrone.nexus.model.WeatherResponse;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.ZoneOffset;

@Service
public class WeatherService
{
    @Value("${weather.api.key}")
    private String _apiKey;

    public WeatherResponse getWeather(Double lat, Double lon)
    {
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" +
        lat + "&lon=" + lon + "&appid=" + _apiKey + "&units=metric";

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);

            String cityName = root.path("name").asText();
            String condition = root.path("weather").get(0).path("description").asText();
            int timezoneOffset = root.path("timezone").asInt();
            ZoneId zone = ZoneId.ofOffset("UTC", ZoneOffset.ofTotalSeconds(timezoneOffset));
            Long sunrise = Long.parseLong(root.path("sys").path("sunrise").asText());
            Long sunset = Long.parseLong(root.path("sys").path("sunset").asText());
            double temperature = root.path("main").path("temp").asDouble();
            double feelsLike = root.path("main").path("feels_like").asDouble();
            int humidity = root.path("main").path("humidity").asInt();
            int pressure = root.path("main").path("pressure").asInt();
            String unit = "C";

            String sunriseFormatted = Instant.ofEpochSecond(sunrise)
            .atZone(zone).format(DateTimeFormatter.ofPattern("h:mm a"));

            String sunsetFormatted = Instant.ofEpochSecond(sunset)
            .atZone(zone).format(DateTimeFormatter.ofPattern("h:mm a"));

            return new WeatherResponse(cityName, condition, sunriseFormatted, sunsetFormatted, temperature, feelsLike, humidity, pressure, unit);
        }
        catch (Exception e)
        {
            // Handle parsing error
            return null;
        }
    }
}