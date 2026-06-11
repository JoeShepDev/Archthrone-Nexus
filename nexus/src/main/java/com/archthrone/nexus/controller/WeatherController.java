package com.archthrone.nexus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController 
{
    @GetMapping
    public String getWeather(@RequestParam double lat, @RequestParam double lon) 
    {
        return "Weather endpoint hit - lat: " + lat + " lon: " + lon;
    }
}