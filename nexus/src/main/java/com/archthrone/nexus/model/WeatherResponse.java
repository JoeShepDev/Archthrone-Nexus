package com.archthrone.nexus.model;

public class WeatherResponse
{
    String _cityName;
    String _condition;
    String _sunrise;
    String _sunset;
    double _temperature;
    double _feelsLike;
    int _humidity;
    int _pressure;
    String _unit;

    public String getCityName() 
    {
        return _cityName;
    }

    public String getCondition() 
    {
        return _condition;
    }

    public String getSunrise() 
    {
        return _sunrise;
    }

    public String getSunset() 
    {
        return _sunset;
    }

    public double getTemperature() 
    {
        return _temperature;
    }

    public double getFeelsLike() 
    {
        return _feelsLike;
    }

    public int getHumidity() 
    {
        return _humidity;
    }

    public int getPressure() 
    {
        return _pressure;
    }

    public String getUnit() 
    {
        return _unit;
    }

    public WeatherResponse(String cityName, String condition, String sunrise, String sunset, double temperature, double feelsLike, int humidity, int pressure, String unit) 
    {
        _cityName = cityName;
        _condition = condition;
        _sunrise = sunrise;
        _sunset = sunset;
        _temperature = temperature;
        _feelsLike = feelsLike;
        _humidity = humidity;
        _pressure = pressure;
        _unit = unit;
    }
}