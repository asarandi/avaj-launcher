package com._42;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        String w[] = {"RAIN", "FOG", "SUN", "SNOW"};
        int idx = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        return w[idx % w.length];
    }
    void changeWeather(){
        super.conditionsChanged();
    }
}
