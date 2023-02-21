package com.econrich.task.regions.dto;

import com.econrich.task.regions.domain.Regions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class RegionsResponse {
    private Long regionId;
    private String regionName;

    public static RegionsResponse of(Regions regions) {
        return RegionsResponse.builder()
                .regionId(regions.getRegionId())
                .regionName(regions.getRegionName())
                .build();
    }
}
