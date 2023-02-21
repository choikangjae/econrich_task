package com.econrich.task.locations.domain;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationsRepository extends JpaRepository<Locations, Long> {
    @EntityGraph(attributePaths = {"countries", "countries.regions"})
    Optional<Locations> findByLocationId(Long locationId);
}
