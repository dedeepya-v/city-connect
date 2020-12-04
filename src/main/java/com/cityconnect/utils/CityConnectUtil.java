package com.cityconnect.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import com.cityconnect.exception.CityConnectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.cityconnect.model.CityConnectData;

/**
 *
 * Util class which uses a graph data structure to check if two cities are connected
 * @author dedeepyavinjam
 *
 */
@Component
public class CityConnectUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityConnectUtil.class);

    @Autowired
    private CityConnectData cityConnectData;

    @Autowired
    private ResourceLoader resourceLoader;

    /**
     * @param resourceLoader to retrieve resources
     * @param cityConnectData data structure to maintain the city guide
     */
    public CityConnectUtil(ResourceLoader resourceLoader, CityConnectData cityConnectData){
        this.cityConnectData = cityConnectData;
        this.resourceLoader = resourceLoader;
        loadData("classpath:city.txt");
    }

    /**
     * This method evaluates if two cities are connected based on given origin and destination
     * @param origin		city
     * @param destination	city
     * @return boolean
     */
    public boolean isConnected(String origin, String destination) throws CityConnectException{
        try {
            // maintain list of cities that we have visited
            Set<String> visited = new LinkedHashSet<>();

            // create a queue for city traversal
            Queue<String> queue = new LinkedList<>();

            //check if the origin and destination both cities are present in the graph
            if(!cityConnectData.isValidCity(origin) && !cityConnectData.isValidCity(destination)) {
                return false;
            }
            // begin with your origin city
            queue.add(origin);
            visited.add(origin);

            // traverse cities to see if destination is connected
            while (!queue.isEmpty()) {
                // pop the current city from queue
                String currentCity = queue.poll();

                // check if we reached the destination already
                if (currentCity.equals(destination)) {
                    return true;
                }

                // now add current city's adjacent cities to the queue which are not visited
                for (String city : cityConnectData.getAdjacentCities(currentCity)) {
                    if (!visited.contains(city)) {
                        visited.add(city);
                        queue.add(city);
                    }
                }
            }
        } catch (Exception e){
            throw new CityConnectException();
        }
        // destination never reached
        return false;
    }

    /**
     * Retrieve resource data from the classpath and load the city guide datastructure
     * @param cityConnectionsFilePath	file path to load the data
     */
    private void loadData(String cityConnectionsFilePath) {
        Resource resource = resourceLoader.getResource(cityConnectionsFilePath);
        InputStream in;
        BufferedReader reader;
        try {
            in = resource.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));
            while (true) {
                String line = reader.readLine();
                if (line != null) {
                    String[] city = line.split(",");
                    cityConnectData.addConnection(city[0].trim(), city[1].trim());
                } else {
                    break;
                }
            }
            reader.close();
            LOGGER.debug("City Guide loaded successfully !");
        } catch (Exception e) {
            LOGGER.error("Error occured while loading file or populating city guide", e);
        }
    }

}
