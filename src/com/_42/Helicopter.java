package com._42;

import java.util.HashMap;
import java.util.Map;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void registerTower(WeatherTower weatherTower){
        weatherTower.register(this);

    }
    public void updateConditions() {
        Map<String, String> msg = new HashMap<>();
        msg.put("RAIN", "heli rain message");
        msg.put("FOG",  "heli  fog message");
        msg.put("SUN",  "heli  sun message");
        msg.put("SNOW", "heli snow message");
        String w = weatherTower.getWeather(this.coordinates);
        System.out.printf("Helicopter#%s(%d): %s\n", this.name, this.id, msg.get(w));
    }
}
