package com.econrich.task.locations.domain;

import com.econrich.task.countries.Countries;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Locations {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long locationId;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Countries countries;
}
