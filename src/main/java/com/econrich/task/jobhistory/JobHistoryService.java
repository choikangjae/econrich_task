package com.econrich.task.jobhistory;

import com.econrich.task.exception.BaseException;
import com.econrich.task.exception.ErrorType;
import com.econrich.task.jobhistory.domain.JobHistory;
import com.econrich.task.jobhistory.domain.JobHistoryRepository;
import com.econrich.task.jobhistory.dto.JobHistoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class JobHistoryService {
    private final JobHistoryRepository jobHistoryRepository;

    @Transactional(readOnly = true)
    public List<JobHistoryResponse> getJobHistoriesByEmployeeId(Long employeeId) {
        List<JobHistory> jobHistories = jobHistoryRepository.findAllByIdEmployeeId(employeeId);
        if (jobHistories.size() == 0) throw new BaseException(ErrorType.JOBHISTORY_NOT_FOUND);

        return jobHistories.stream().map(JobHistoryResponse::of).collect(Collectors.toList());
    }
}
