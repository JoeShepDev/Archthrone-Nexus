A personal REST API built with Java Spring Boot, deployed on a self-managed Linux VPS. Serves as the backend infrastructure for a growing ecosystem of personal tools and integrations.

Overview

Archstone Nexus is a living API — starting with a weather endpoint and expanding into finance tracking, YouTube analytics, stock data, and more. Deployed on a personal VPS with systemd persistence and managed via Docker.

Live Endpoints

Weather

GET /weather?city={city}&units={imperial|metric}

Returns current weather conditions including temperature, feels like, humidity, pressure, condition, and formatted sunrise/sunset times.

Example:

GET /weather?city=Atlanta&units=imperial

Tech Stack


Language: Java
Framework: Spring Boot
HTTP Client: RestTemplate
JSON Parsing: Jackson ObjectMapper
External API: OpenWeatherMap
Deployment: Linux VPS · Docker · systemd
Version Control: Git / GitHub


Project Structure

src/
├── controller/
│   └── WeatherController.java
├── service/
│   └── WeatherService.java
└── model/
    └── WeatherResponse.java

Planned Endpoints


Finance tracker
YouTube analytics
Stock market data
Reddit feed aggregator


Status

In active development — weather endpoint live, additional endpoints in progress.

Notes

application.properties is gitignored to protect API keys. Environment variables required for local setup.
