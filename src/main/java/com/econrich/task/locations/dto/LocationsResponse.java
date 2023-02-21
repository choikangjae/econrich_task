package com.econrich.task.locations.dto;

import com.econrich.task.countries.CountriesResponse;
import com.econrich.task.locations.domain.Locations;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class LocationsResponse {
    private Long locationId;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private CountriesResponse countriesResponse;

    public static LocationsResponse of(Locations locations) {
        return LocationsResponse.builder()
                .locationId(locations.getLocationId())
                .streetAddress(locations.getStreetAddress())
                .postalCode(locations.getPostalCode())
                .city(locations.getCity())
                .stateProvince(locations.getStateProvince())
                .countriesResponse(CountriesResponse.of(locations.getCountries()))
                .build();
    }
}
