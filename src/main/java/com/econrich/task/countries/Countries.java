package com.econrich.task.countries;

import com.econrich.task.regions.domain.Regions;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Countries {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String countryId;
    private String countryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Regions regions;
}
