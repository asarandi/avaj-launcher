package com._42;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Simulator {

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

        try {
            in = new Scanner(new File(args[0]));
        } catch (IOException e) {
            System.out.println("error: could not read file");
            System.exit(0);
        }

        if (in.hasNext()) {
            s = in.nextLine();
            if (s.matches("^\\d+$")) {
                try {
                    numSimulations = Integer.parseInt(s);
                    isValid = true;
                } catch (Exception e) {
                    System.out.println("error: number of simulations - int out of range");
                }    //num too big or too small
            } else {
                System.out.println("error: first line of input should be number of simulations");
            }
            if (isValid && numSimulations <= 0){
                System.out.println("error: number of simulations - must be greater than 0");
                isValid = false;
            }
        }

        while (isValid && in.hasNext()) {
            s = in.nextLine();
            if (s.matches("^\\w+\\s+\\w+\\s+\\d+\\s+\\d+\\s+\\d+$")){
                split = s.split("\\s+");
                try {
                    fleet.add(
                            AircraftFactory.newAircraft(
                                    split[0],
                                    split[1],
                                    Integer.parseInt(split[2]),
                                    Integer.parseInt(split[3]),
                                    Integer.parseInt(split[4])
                            )
                    );
                } catch (InvalidAircraftTypeException e) {
                    System.out.println("parse error: invalid aircraft type: " + s);
                } catch (Exception e) {
                    System.out.println("parse error: " + s);    //ints might be out of range
                    isValid = false;
                    break;
                }
            } else {
                System.out.println("parse error: " + s);    //string doesn't match pattern
                isValid = false;
                break;
            }
        }

        in.close();
        if (!isValid) {
            System.exit(0);
        }

        wt = new WeatherTower();
        for (Flyable f : fleet) {
            f.registerTower(wt);
        }

        for (int i=0;i<numSimulations;i++){
            wt.changeWeather();
        }
        
    }
}