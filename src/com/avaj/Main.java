package com.avaj;

import com.avaj.aircontrol.WeatherTower;
import com.avaj.aircraft.AircraftFactory;
import com.avaj.weather.WeatherProvider;

import java.io.*;

public class Main {

    public static PrintWriter writer;
    public static int cycles;

    public static void main(String[] args) {
        //Check for valid input
        if(args.length != 1)
            return;

        //Store Input File Name
        String file = args[0];

        //Create & Initialise log file
        File log = new File("simulation.txt");

        try {
            writer = new PrintWriter(log);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
        if (log.exists() && !log.isDirectory())
            writer.print("");

        AircraftFactory aircraftFactory = new AircraftFactory();
        WeatherTower weatherTower = new WeatherTower();

        try {
            FileInputStream fstream = new FileInputStream(file);
            fstream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String line;
            int lineCounter = 1;

            String params[];

            while ((line = br.readLine()) != null){
                if (lineCounter == 1){
                    try {
                        cycles = Integer.parseInt(line);
                        if (cycles < 0) {
                            System.out.print("Invalid Format");
                            return;
                        }
                    } catch (NumberFormatException e) {
                        System.out.print(e.getMessage());
                        return;
                    }
                }
                else {
                    params = line.split(" ");
                    if (params.length == 1 && params[0].isEmpty())
                        continue;
                    if (params.length != 5) {
                        System.out.print("Invalid Format");
                        return;
                    }
                    try {
                        aircraftFactory.newAircraft(params[0],
                                params[1],
                                Integer.parseInt(params[2]),
                                Integer.parseInt(params[3]),
                                Integer.parseInt(params[4]))
                                .registerTower(weatherTower);
                    } catch (NumberFormatException e) {
                        System.out.print(e.getMessage());
                        return;
                    }
                }
                lineCounter++;
            }

        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        WeatherProvider weatherProvider = WeatherProvider.getProvider();

        while(cycles > 0) {
            weatherTower.changeWeather();
            cycles--;
        }
        writer.close();
    }
}
