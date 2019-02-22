package com._42;

import java.util.HashMap;
import java.util.Map;

public class Balloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Balloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void registerTower(WeatherTower weatherTower){
        weatherTower.register(this);
    }

    public void updateConditions() {
        Map<String, String> msg = new HashMap<>();
        msg.put("RAIN", "balloon rain message");
        msg.put("FOG",  "balloon  fog message");
        msg.put("SUN",  "balloon  sun message");
        msg.put("SNOW", "balloon snow message");
        String w = weatherTower.getWeather(this.coordinates);
        System.out.printf("Balloon#%s(%d): %s\n", this.name, this.id, msg.get(w));
    }
}
