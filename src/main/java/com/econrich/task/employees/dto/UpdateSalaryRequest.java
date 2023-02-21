package com.econrich.task.employees.dto;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSalaryRequest {
    @NotNull
    @Schema(example = "0.05")
    @Parameter(example = "0.0과 1.0 사이의 값을 입력해주세요.")
    @DecimalMin(value = "0.00", message = "0과 1 사이의 값을 입력해주세요 e.g. 5% 인상 == 0.05") @DecimalMax(value = "1.00", message = "0과 1 사이의 값을 입력해주세요 e.g. 5% 인상 == 0.05")
    private Double increaseRate;
    @NotNull
    @Schema(example = "10")
    private Long departmentId;
}
