package com.econrich.task.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Objects;

import static com.econrich.task.exception.ErrorType.METHOD_NOT_ALLOWED;
import static com.econrich.task.exception.ErrorType.PARAM_VALID_ERROR;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException e) {
        String className = e.getClass().getName();
        ErrorType errorType = e.getErrorType();

        if (Objects.isNull(errorType)) {
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .exception(className.substring(className.lastIndexOf(".") + 1))
                    .code(null)
                    .message(e.getMessage())
                    .status(INTERNAL_SERVER_ERROR.value())
                    .error(null)
                    .build();

            return new ResponseEntity<>(errorResponse, INTERNAL_SERVER_ERROR);
        } else {
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .exception(className.substring(className.lastIndexOf(".") + 1))
                    .code(errorType.getCode())
                    .message(errorType.getMessage())
                    .status(errorType.getStatus().value())
                    .error(errorType.getStatus().getReasonPhrase())
                    .build();

            return new ResponseEntity<>(errorResponse, errorType.getStatus());
        }
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class, HttpMessageNotReadableException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ErrorResponse> handleBindValidationException(Exception e) {
        String className = e.getClass().getName();
        ErrorType errorType = PARAM_VALID_ERROR;
        String message = "잘못된 파라미터가 입력되었습니다";
        String field = "";

        if (e instanceof MethodArgumentNotValidException) {
            FieldError fieldError = ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors().get(0);
            message = fieldError.getDefaultMessage();
            field = fieldError.getField();
        } else if (e instanceof BindException) {
            FieldError fieldError = ((BindException) e).getBindingResult().getFieldErrors().get(0);
            message = fieldError.getDefaultMessage();
            field = fieldError.getField();
        }

        ErrorResponse errorResponse = ErrorResponse.builder()
                .exception(className.substring(className.lastIndexOf(".") + 1))
                .code(errorType.getCode())
                .message(message)
                .status(errorType.getStatus().value())
                .error(errorType.getStatus().getReasonPhrase())
                .field(field)
                .build();

        return new ResponseEntity<>(errorResponse, errorType.getStatus());
    }

    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        String className = e.getClass().getName();
        ErrorType errorType = METHOD_NOT_ALLOWED;

        ErrorResponse errorResponse = ErrorResponse.builder()
                .exception(className.substring(className.lastIndexOf(".") + 1))
                .code(errorType.getCode())
                .message(e.getMessage())
                .status(errorType.getStatus().value())
                .error(errorType.getStatus().getReasonPhrase())
                .build();

        return new ResponseEntity<>(errorResponse, errorType.getStatus());
    }
}
