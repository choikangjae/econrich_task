package com.econrich.task.departments;

import com.econrich.task.departments.dto.DepartmentsResponse;
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

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentsController {
    private final DepartmentsService departmentsService;

    @Operation(summary = "부서 정보 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ID에 해당하는 부서 정보를 찾음",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DepartmentsResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "숫자가 아닌 값이 입력됨",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "ID에 해당하는 부서 정보가 존재하지 않음",
                    content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentsById(@Parameter(description = "부서 ID. 10부터 10씩 증가", example = "10") @PathVariable Long id) {
        DepartmentsResponse departmentsResponse = departmentsService.getDepartmentsById(id);
        return ResponseEntity.ok(departmentsResponse);
    }
}
