package com.econrich.task.jobs.domain;

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
public class Jobs {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String jobId;
    private String jobTitle;
    private Integer minSalary;
    private Integer maxSalary;
}
