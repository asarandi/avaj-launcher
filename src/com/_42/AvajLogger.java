package com._42;

import java.io.IOException;
import java.util.logging.*;


public class AvajLogger {
    private static AvajLogger avajLogger = null;
    private Logger logger = Logger.getLogger("global");

    private AvajLogger() {

        FileHandler fh = null;

        try {
            fh = new FileHandler("avaj_sim.txt");
        } catch (IOException e) {
            System.out.println("error: could not open simulation log file");
            System.exit(1);
        }

        fh.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getMessage();
            }
        });
        logger.addHandler(fh);
        logger.setUseParentHandlers(false);
    }

    private static AvajLogger getLogger(){
        if (avajLogger == null) {
            avajLogger = new AvajLogger();
        }
        return avajLogger;
    }

    public static void put(String s){
        getLogger().logger.info(s);
    }

}
