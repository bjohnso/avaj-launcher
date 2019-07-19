package com.avaj.aircraft;

import com.avaj.Main;
import com.avaj.aircontrol.WeatherTower;
import com.avaj.interfaces.Flyable;
import com.avaj.map.Coordinates;

import java.util.HashMap;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name, "Helicopter", coordinates);
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(this.getCoordinates());
        HashMap <String, String> messages = new HashMap<>();
        messages.put("SUN", "It's sunny : Longitude +10 and Height +2");
        messages.put("RAIN", "It's rainy : Longitude +5");
        messages.put("FOG", "It's foggy : Longitude +1");
        messages.put("SNOW", "It's snowy : Height -12");
        messages.put("LANDING", "I'm landing at coordinates ");

        if (weather.equals("SUN")) {
            this.mCoordinates.mutateLongitude(10);
            this.mCoordinates.mutateHeight(2);
        }
        else if (weather.equals("RAIN")) {
            this.mCoordinates.mutateLongitude(5);
        }
        else if (weather.equals("FOG")){
            this.mCoordinates.mutateLongitude(1);
        }
        else {
            this.mCoordinates.mutateHeight(-12);
        }

        Main.writer.println("Helicopter#" + this.mName + "(" + this.mId + "): "
                + messages.get(weather) + " : new coordinates " + this.mCoordinates);

        if (this.mCoordinates.getHeight() == 0){

            Main.writer.println("Helicopter#" + this.mName + "(" + this.mId + "): "
                    + messages.get("LANDING") + this.mCoordinates);
            this.weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}
