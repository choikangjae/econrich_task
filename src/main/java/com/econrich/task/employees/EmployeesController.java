package com.econrich.task.employees;

import com.econrich.task.employees.dto.EmployeesResponse;
import com.econrich.task.employees.dto.UpdateEmployeeInfoRequest;
import com.econrich.task.employees.dto.UpdateSalaryRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeesController {
    private final EmployeesService employeesService;

    @Operation(summary = "사원 정보 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ID에 해당하는 사원 정보를 찾음",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmployeesResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "숫자가 아닌 값이 입력됨",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "ID에 해당하는 사원 정보가 존재하지 않음",
                    content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeInfoById(@Parameter(description = "사원 ID. 101부터 1씩 증가",example = "101") @PathVariable Long id) {
        EmployeesResponse employeesResponse = employeesService.findById(id);
        return ResponseEntity.ok(employeesResponse);
    }

    @Operation(summary = "특정 부서 급여를 특정 비율로 인상")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "특정 부서 급여를 특정 비율로 인상하는데 성공",
                    content = { @Content(schema = @Schema(example = "급여가 인상된 사원 총 인원")), }),
            @ApiResponse(responseCode = "400", description = "숫자가 아닌 값이 입력됨",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "ID에 해당하는 부서가 존재하지 않음",
                    content = @Content) })
    @PostMapping
    public ResponseEntity<?> updateEmployeesSalaryByDepartment(@Valid @RequestBody UpdateSalaryRequest request) {
        int updatedEmployeeCount = employeesService.increaseEmployeeSalaryByPercentageInDepartmentId(request);
        return ResponseEntity.ok(updatedEmployeeCount);
    }

    @Operation(summary = "유저 정보 업데이트")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 정보 업데이트에 성공함",
                    content = { @Content(schema = @Schema(example = "null")) }),
            @ApiResponse(responseCode = "404", description = "ID에 해당하는 사원 정보가 존재하지 않음",
                    content = @Content) })
    @PostMapping("/{id}")
    public ResponseEntity<?> updateEmployeeInfo(@Parameter(description = "사원 ID. 101부터 1씩 증가",example = "101") @PathVariable Long id, @RequestBody UpdateEmployeeInfoRequest request) {
        employeesService.updateEmployeeInfo(id, request);
        return ResponseEntity.ok(null);
    }
}
