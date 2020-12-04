package com.cityconnect.service;

import com.cityconnect.exception.CityConnectException;

/**
 * Interface for City Connect Service
 * @author dedeepyavinjam
 *
 */
public interface CityConnectService {

    /**
     * This method will check if origin and destination cities are connected
     * @param origin		city
     * @param destination	city
     * @return boolean
     */
    boolean isConnected(String origin, String destination) throws CityConnectException;

}