package com._42;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        Coordinates coords = new Coordinates(longitude, latitude, height);
        if (type.equalsIgnoreCase("helicopter")) {
            return new Helicopter(name, coords);
        } else if (type.equalsIgnoreCase("jetplane")) {
            return new Jetplane(name, coords);
        } else if (type.equalsIgnoreCase("balloon")) {
                return new Balloon(name, coords);
        } else {
            return null;
        }
    }
}