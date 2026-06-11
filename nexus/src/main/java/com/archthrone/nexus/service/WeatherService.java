package com.archthrone.nexus.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
public class WeatherService
{
    @Value("${weather.api.key}")
    private String _apiKey;
}