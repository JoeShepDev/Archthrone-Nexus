package com.archthrone.nexus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.archthrone.nexus.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import com.archthrone.nexus.model.WeatherResponse;

@RestController
@RequestMapping("/api/weather")
public class WeatherController 
{
    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public WeatherResponse getWeather(@RequestParam double lat, @RequestParam double lon, @RequestParam(defaultValue = "metric") String units)
    {
        return weatherService.getWeather(lat, lon, units);
    }
}