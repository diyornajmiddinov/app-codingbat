package uz.pdp.codingbat.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@RequiredArgsConstructor
public class ApiException {
    private final String message;
    private final Throwable cause;
    private final HttpStatus httpStatus;
    private final ZonedDateTime zonedDateTime;
}
