package webCalendarSpring;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EventInvalidRequestParametersExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<String> handleInvalidRequestParameter(Exception ex) {
        System.out.println("Something went wrong: " + ex.getMessage());
        return new ResponseEntity<>(
                "",
                HttpStatusCode.valueOf(400)
        );
    }

    @ExceptionHandler(value = EventNotFoundException.class)
    public ResponseEntity<ExceptionHandlerResponseDto> handleEventNotFound(Exception ex) {
        System.out.println("Something went wrong: " + ex.getMessage());
        return new ResponseEntity<>(
                new ExceptionHandlerResponseDto("The event doesn't exist!"),
                HttpStatusCode.valueOf(404)
        );
    }

    public record ExceptionHandlerResponseDto(String message) {

    }

}
