package com._42;

public class Lookups {

    private static String[] flyables = {"Jetplane", "Helicopter", "Balloon"};

    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private static String[][] msg = {
            {
                    "jetplane sun msg",
                    "It's raining. Better watch out for lightings.",
                    "jetplane fog msg",
                    "OMG! Winter is coming!"
            },
            {
                    "This is hot.",
                    "heli rain msg",
                    "heli fog msg",
                    "My rotor is going to freeze!"
            },
            {
                    "Let's enjoy the good weather and take some pics.",
                    "Damn you rain! You messed up my baloon.",
                    "balloon fog msg",
                    "It's snowing. We're gonna crash."
            }
    };

    private static int coords[][][] = {
            {   //jetplane
                    //lon, lat, hgt
                    {0,10,2},   //sun
                    {0,5,0},    //rain
                    {0,1,0},    //fog
                    {0,0,-7}    //snow
            },
            {   //helicopter
                    //lon, lat, hgt
                    {10,0,2},   //sun
                    {5,0,0},    //rain
                    {1,0,0},    //fog
                    {0,0,-12}   //snow
            },
            {   //balloon
                    //lon, lat, hgt
                    {2,0,4},    //sun
                    {0,0,-5},   //rain
                    {0,0,-3},   //fog
                    {0,0,-15}    //snow
            }
    };

    private static int indexOf(String[] arr, String e){
        for (int i=0; i<arr.length;i++){
            if (arr[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public static int getLongitude(String f, String w){
        int i = indexOf(flyables, f);
        int j = indexOf(weather, w);
        return coords[i][j][0];
    }

    public static int getLatitude(String f, String w){
        int i = indexOf(flyables, f);
        int j = indexOf(weather, w);
        return coords[i][j][1];
    }

    public static int getHeight(String f, String w){
        int i = indexOf(flyables, f);
        int j = indexOf(weather, w);
        return coords[i][j][2];
    }

    public static String getMessage(String f, String w){
        int i = indexOf(flyables, f);
        int j = indexOf(weather, w);
        return msg[i][j];
    }
}
