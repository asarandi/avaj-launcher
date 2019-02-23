package com._42;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner in = null;
        int numSimulations = -1;
        boolean isValid = false;
        String s;
        String split[];
        WeatherTower wt;
        List<Flyable> fleet = new ArrayList<>();

        if (args.length != 1) {
            System.out.println("usage: program <scenario_file.txt>");
            System.exit(1);
        }

        System.out.println("reading from: " + args[0]);
        
        try {
            in = new Scanner(new File(args[0]));
        } catch (IOException e) {
            System.out.println("could not read file");
            System.exit(0);
        }

        if (in.hasNext()) {
            s = in.nextLine();
            if (s.matches("^\\d+$")) {
                try {
                    numSimulations = Integer.parseInt(s);
                    isValid = true;
                } catch (Exception e) {}    //num too big or too small
            }
        }

        if (!isValid) {
            System.out.println("error: first line of input should be number of simulations");
        }


        while (isValid && in.hasNext()) {
            s = in.nextLine();
            if (s.matches("^\\w+\\s+\\w+\\s+\\d+\\s+\\d+\\s+\\d+$")){
                split = s.split("\\s+");
                fleet.add(
                        AircraftFactory.newAircraft(
                            split[0],
                            split[1],
                            Integer.parseInt(split[2]),
                            Integer.parseInt(split[3]),
                            Integer.parseInt(split[4])
                    )
                );
            } else {
                System.out.println("parse error: " + s);
                isValid = false;
                break;
            }
        }



        in.close();
        if (!isValid) {
            System.exit(0);
        }

        wt = new WeatherTower();

        WeatherProvider wp = WeatherProvider.getProvider();
        String cw = wp.getCurrentWeather(new Coordinates(1,2,3));
        System.out.println(cw);


        for (Flyable f : fleet) {
            f.registerTower(wt);
        }
        for (int i=0;i<numSimulations;i++){
            wt.changeWeather();
        }
        
    }
}