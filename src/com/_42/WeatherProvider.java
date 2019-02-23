package com._42;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = null;
    private static String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};
    private WeatherProvider() {};
    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates){
        int idx = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        return weather[idx % weather.length];
    }
}
