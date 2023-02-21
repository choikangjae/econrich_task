package com.econrich.task.jobs.dto;

import com.econrich.task.jobs.domain.Jobs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class JobsResponse {
    private String jobId;
    private String jobTitle;
    private Integer minSalary;
    private Integer maxSalary;

    public static JobsResponse of(Jobs jobs) {
        return JobsResponse.builder()
                .jobId(jobs.getJobId())
                .jobTitle(jobs.getJobTitle())
                .minSalary(jobs.getMinSalary())
                .maxSalary(jobs.getMaxSalary())
                .build();
    }
}
