package com.econrich.task.jobhistory;

import com.econrich.task.jobhistory.dto.JobHistoryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/job_history")
@RequiredArgsConstructor
public class JobHistoryController {
    private final JobHistoryService jobHistoryService;

    @Operation(summary = "특정 사원의 이력 정보 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ID에 해당하는 사원의 이력 정보를 찾음",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = JobHistoryResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "숫자가 아닌 값이 입력됨",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "사원 ID에 해당하는 이력 정보가 존재하지 않음",
                    content = @Content) })
    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getInfoById(@Parameter(description = "사원 ID. 101부터 1씩 증가", example = "101") @PathVariable Long employeeId) {
        List<JobHistoryResponse> jobHistoriesByEmployeeId = jobHistoryService.getJobHistoriesByEmployeeId(employeeId);
        return ResponseEntity.ok(jobHistoriesByEmployeeId);
    }
}
