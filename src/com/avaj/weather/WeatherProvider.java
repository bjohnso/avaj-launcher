package com.avaj.weather;

import com.avaj.map.Coordinates;

public class WeatherProvider {

    private static WeatherProvider mWeatherProvider = new WeatherProvider();
    private String[] mWeather = {
            "RAIN",
            "FOG",
            "SUN",
            "SNOW"
    };

    private static String[] biome = {
            "SWAMP",
            "JUNGLE",
            "FOREST",
            "WINTER",
            "DESERT"
    };
    private WeatherProvider(){

    }

    public static WeatherProvider getProvider(){
        return WeatherProvider.mWeatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int latitude = coordinates.getLatitude();
        int longitude = coordinates.getLongitude();
        int height = coordinates.getHeight();

        int biomeSeed = latitude + longitude;
        double timeSeed = Math.random() * 2;
        double weatherSeed = Math.random();

        String randomBiome = biome[biomeSeed % 5];

        switch (randomBiome) {
            case "SWAMP":
                if (weatherSeed < 1.0 / 14.0 && height > 50)
                    return mWeather[3];
                else if (weatherSeed < 4.0 / 14.0 && height > 30)
                    return mWeather[2];
                else if (weatherSeed < 8.0 / 14.0)
                    return mWeather[0];
                else
                    return mWeather[1];

            case "JUNGLE":
                if (weatherSeed < 1.0 / 14.0 && height > 50)
                    return mWeather[3];
                else if (weatherSeed < 4.0 / 14.0 && height > 30)
                    return mWeather[1];
                else if (weatherSeed < 8.0 / 14.0)
                    return mWeather[0];
                else
                    return mWeather[2];

            case "FOREST":
                if (weatherSeed < 1.0 / 14.0 && height > 50)
                    return mWeather[3];
                else if (weatherSeed < 4.0 / 14.0 && height > 30)
                    return mWeather[2];
                else if (weatherSeed < 8.0 / 14.0)
                    return mWeather[2];
                else
                    return mWeather[0];
            case "WINTER":
                if (weatherSeed < 1.0 / 14.0 && height > 50)
                    return mWeather[2];
                else if (weatherSeed < 4.0 / 14.0 && height > 30)
                    return mWeather[1];
                else if (weatherSeed < 8.0 / 14.0)
                    return mWeather[0];
                else
                    return mWeather[3];
            case "DESERT":
                if (weatherSeed < 1.0 / 14.0 && height > 50)
                    return mWeather[0];
                else if (weatherSeed < 4.0 / 14.0 && height > 30)
                    return mWeather[0];
                else if (weatherSeed < 8.0 / 14.0)
                    return mWeather[2];
                else
                    return mWeather[2];

        }
        return mWeather[biomeSeed % 4];
    }
}
