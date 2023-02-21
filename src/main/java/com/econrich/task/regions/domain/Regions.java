package com.econrich.task.regions.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Regions {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long regionId;
    private String regionName;
}
