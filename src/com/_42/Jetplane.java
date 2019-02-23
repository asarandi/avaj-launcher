package com._42;

import java.util.HashMap;
import java.util.Map;

public class Jetplane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Jetplane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void registerTower(WeatherTower weatherTower){
        weatherTower.register(this);

    }
    public void updateConditions() {
        Map<String, String> msg = new HashMap<>();
        msg.put("RAIN", "jetplane rain message");
        msg.put("FOG",  "jetplane  fog message");
        msg.put("SUN",  "jetplane  sun message");
        msg.put("SNOW", "jetplane snow message");
        String w = weatherTower.getWeather(this.coordinates);
        System.out.printf("JetPlane#%s(%d): %s\n", this.name, this.id, msg.get(w));
    }

    @Override
    public String toString() {
        return "JetPlane#" +  name + '(' + id + ')';
    }
}
