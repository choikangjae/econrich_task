package com.econrich.task.jobhistory.domain;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * When mapping an @Embeddable composite identifier:
 * <p>
 * 1. You need the @Embeddable type to be Serializable
 * <br>
 * 2. The @Embeddable type must override the default equals and hashCode methods based on the two Primary Key identifier values.
 * </p>
 */
@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class JobHistoryId implements Serializable {
    @EqualsAndHashCode.Include
    private Long employeeId;
    @EqualsAndHashCode.Include
    private String jobId;
    @EqualsAndHashCode.Include
    private Long departmentId;
}
