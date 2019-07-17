package com.avaj.aircontrol;

import com.avaj.map.Coordinates;
import com.avaj.weather.WeatherProvider;

public class WeatherTower extends Tower{

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather(){
        this.conditionsChanged();
    }

}
