package com.archthrone.nexus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.archthrone.nexus.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/weather")
public class WeatherController 
{
    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public String getWeather(@RequestParam double lat, @RequestParam double lon) 
    {
        return weatherService.getWeather(lat, lon);
    }
}