package com.cityconnect.utils;

/**
 * Constants for City Connect Service
 *
 * @author dedeepyavinjam
 *
 */
public class CityConnectConstants {

    private CityConnectConstants(){
        // TO Avoid Object Creation
    }

    public static final String CONNECTED_MESSAGE = "Hurray, They are Connected :)";
    public static final String NOT_CONNECTED_MESSAGE = "Sorry, They are not connected :(";
    public static final String SERVICE_ERROR_MESSAGE = "Sorry, We couldn't serve your request at this moment due to an internal Error";
    public static final String INVALID_CITY_ERROR = "Please provide valid Origin & Destination";
    public static final String ORIGIN_CITY = "Origin City";
    public static final String DESTINATION_CITY = "Destination City";
}
