package uz.pdp.codingbat.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;
@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiException apiException;
        apiException = new ApiException(
                e.getMessage(),
                e,
                httpStatus,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(apiException, httpStatus);
    }
}
