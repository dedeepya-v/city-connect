package com.cityconnect.controller;

import com.cityconnect.service.CityConnectService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.cityconnect.utils.CityConnectConstants.*;

/**
 * REST APIs for City Connect Application
 *
 * @author dedeepyavinjam
 *
 */
@RestController
@EnableSwagger2
@Api(tags = "City Connect", value = "City Connect")
public class CityConnectController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityConnectController.class);

    private CityConnectService cityConnectService;

    public CityConnectController(CityConnectService cityConnectService) {
        this.cityConnectService = cityConnectService;
    }

    /**
     * API to check if the cities are connected
     *
     * @param origin      city
     * @param destination city
     * @return Yes or No based on the connectivity
     */
    @ApiOperation(value = "City Connect Service", notes = "Check the connectivity between two cities", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = CONNECTED_MESSAGE, response = String.class),
            @ApiResponse(code = 500, message = NOT_CONNECTED_MESSAGE, response = Exception.class) })
    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String checkCityConnectivity(
            @ApiParam(value = ORIGIN_CITY) @RequestParam(name = "origin", required = true) String origin,
            @ApiParam(value = DESTINATION_CITY) @RequestParam(name = "destination", required = true) String destination) {
        if (origin.isEmpty() || destination.isEmpty()) return INVALID_CITY_ERROR;
        LOGGER.info("City Connect Request Received for Origin {} => Destination {}", origin, destination);
        return cityConnectService.isConnected(origin, destination) ?
                CONNECTED_MESSAGE : NOT_CONNECTED_MESSAGE;
    }
}