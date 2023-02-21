package com.econrich.task.locations;

import com.econrich.task.exception.BaseException;
import com.econrich.task.exception.ErrorType;
import com.econrich.task.locations.domain.Locations;
import com.econrich.task.locations.domain.LocationsRepository;
import com.econrich.task.locations.dto.LocationsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LocationsService {
    private final LocationsRepository locationsRepository;

    public LocationsResponse getLocationsById(Long id) {
        Locations locations = locationsRepository.findByLocationId(id)
                .orElseThrow(() -> new BaseException(ErrorType.LOCATION_NOT_FOUND));
        return LocationsResponse.of(locations);
    }
}
