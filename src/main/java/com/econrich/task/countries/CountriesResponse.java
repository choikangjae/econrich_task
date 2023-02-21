package com.econrich.task.countries;

import com.econrich.task.regions.dto.RegionsResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CountriesResponse {
    private String countryId;
    private String countryName;
    private RegionsResponse regionsResponse;

    public static CountriesResponse of(Countries countries) {
        return CountriesResponse.builder()
                .countryId(countries.getCountryId())
                .countryName(countries.getCountryName())
                .regionsResponse(RegionsResponse.of(countries.getRegions()))
                .build();
    }
}
