package com.econrich.task.openapi;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OpenApiRequest {
    @Schema(example = "1")
    private Long pageNo = 1L;
    @Schema(example = "10")
    private Long numOfRows = 10L;
    @Schema(example = "55")
    private Long nx = 55L;
    @Schema(example = "127")
    private Long ny = 127L;
}
