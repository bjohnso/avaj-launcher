package com.avaj.interfaces;

import com.avaj.aircontrol.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}
