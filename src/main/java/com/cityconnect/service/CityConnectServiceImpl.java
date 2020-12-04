package com.cityconnect.service;

import com.cityconnect.utils.CityConnectUtil;
import org.springframework.stereotype.Service;

/**
 * Service to check the the connectivity between two cities
 * @author dedeepyavinjam
 */
@Service
public class CityConnectServiceImpl implements CityConnectService {

    public CityConnectServiceImpl(CityConnectUtil cityConnectUtil){
        this.cityConnectUtil = cityConnectUtil;
    }

    private CityConnectUtil cityConnectUtil;

    /**
     * this method will check if the two cities are connected
     * @param origin			city
     * @param destination	city
     * @return boolean
     */
    @Override
    public boolean isConnected(String origin, String destination) {
        return cityConnectUtil.isConnected(origin, destination);
    }
}