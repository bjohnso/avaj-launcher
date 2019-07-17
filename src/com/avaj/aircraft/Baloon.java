package com.avaj.aircraft;

import com.avaj.aircontrol.WeatherTower;
import com.avaj.interfaces.Flyable;
import com.avaj.map.Coordinates;

import java.util.HashMap;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates){
        super(name, "Baloon", coordinates);
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(this.mCoordinates);
        HashMap<String, String> messages = new HashMap<>();
        messages.put("SUN", "It's sunny : Longitude +2 and Height +4");
        messages.put("RAIN", "It's rainy : Height -5");
        messages.put("FOG", "It's foggy : Height -3");
        messages.put("SNOW", "It's snowy : Height -15");

        if (weather.equals("SUN")) {
            this.mCoordinates.mutateLongitude(2);
            this.mCoordinates.mutateHeight(4);
        }
        else if (weather.equals("RAIN")) {
            this.mCoordinates.mutateHeight(-5);
        }
        else if (weather.equals("FOG")){
            this.mCoordinates.mutateHeight(-3);
        }
        else {
            this.mCoordinates.mutateHeight(-15);
        }
        System.out.println("Baloon#" + this.mName + "(" + this.mId + "): "
                + messages.get(weather));

        if (this.mCoordinates.getHeight() == 0){

            System.out.println("Baloon#" + this.mName + "(" + this.mId + "): "
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
