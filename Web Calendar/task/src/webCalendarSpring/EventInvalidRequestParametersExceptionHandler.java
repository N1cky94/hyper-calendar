package webCalendarSpring;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EventInvalidRequestParametersExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<String> handleInvalidRequestParameter() {
        System.out.println("Something went wrong - 400");
        return new ResponseEntity<>("", HttpStatusCode.valueOf(400));
    }

    public record InvalidParameterExceptionDto() {

    }

}
