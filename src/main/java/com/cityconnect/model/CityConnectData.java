package com.cityconnect.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Model to hold connectivity between all cities
 *
 * @author dedeepyavinjam
 *
 */
@Component
public class CityConnectData {

    private Map<String, List<String>> adjacentCities = new HashMap<>();

    public List<String> getAdjacentCities(String name) {
        return adjacentCities.get(name);
    }

    public boolean isValidCity(String city) {
        return adjacentCities.containsKey(city);
    }

    public void addConnection(String origin, String destination) {

        if (!adjacentCities.containsKey(origin))
            addCity(origin);

        if (!adjacentCities.containsKey(destination))
            addCity(destination);

        adjacentCities.get(origin).add(destination);
        adjacentCities.get(destination).add(origin);
    }

    public void addCity(String name) {
        adjacentCities.put(name, new ArrayList<>());
    }

}
